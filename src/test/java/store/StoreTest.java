package store;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.petstore.service.store.StoreService;
import org.petstore.config.rest.Config;
import org.petstore.models.order.Order;
import org.petstore.models.order.status.OrderStatus;
import org.petstore.models.pet.Pet;
import org.petstore.util.factory.order.OrderFactory;
import org.petstore.util.factory.pet.PetFactory;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StoreTest {

    private static StoreService stores;
    private static Pet pet;

    @BeforeAll
    static void setup() {
        Config.setup();
        stores = new StoreService();
        pet = PetFactory.generatePet();
    }

    @Test
    void testPlaceAndGetOrder() {
        Order order = OrderFactory.generateOrder(pet.getId());
        order.setId(5);
        stores.placeOrder(order)
                .then()
                .statusCode(200)
                .body("id", equalTo(5));

        Order responseOrder = stores.getOrderById(5L)
                .then()
                .statusCode(200)
                .extract().as(Order.class);

        assertThat(responseOrder.getPetId(), equalTo(pet.getId()));
    }

    @Test
    void testCreateOrderWithMinimalData() {
        Order minimalOrder = new Order();
        minimalOrder.setId(3);
        minimalOrder.setPetId(pet.getId());
        minimalOrder.setShipDate(OffsetDateTime.now(ZoneOffset.UTC).toString());
        minimalOrder.setStatus(OrderStatus.PLACED);
        minimalOrder.setComplete(false);

        stores.placeOrder(minimalOrder)
                .then()
                .statusCode(200)
                .body("petId", equalTo(pet.getId()));
    }

    @Test
    void testDeleteOrder() {
        Order order = OrderFactory.generateOrder(pet.getId());
        order.setId(4);
        stores.placeOrder(order)
                .then()
                .statusCode(200);

        stores.deleteOrder(order.getId())
                .then()
                .statusCode(200);

        stores.getOrderById(order.getId())
                .then()
                .statusCode(404);
    }
}

