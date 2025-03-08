package store;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.petstore.api.store.StoreService;
import org.petstore.config.rest.Config;
import org.petstore.models.order.Order;
import org.petstore.models.pet.Pet;
import org.petstore.util.factory.order.OrderFactory;
import org.petstore.util.factory.pet.PetFactory;

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
        System.out.println(order.getShipDate());
        stores.placeOrder(order)
                .then()
                .statusCode(200);

        Order responseOrder = stores.getOrderById(order.getId())
                .then()
                .statusCode(200)
                .extract().as(Order.class);

        assertThat(responseOrder.getPetId(), equalTo(pet.getId()));
    }
}

