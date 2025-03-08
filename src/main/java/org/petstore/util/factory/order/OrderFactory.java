package org.petstore.util.factory.order;

import net.datafaker.Faker;
import org.petstore.models.order.Order;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OrderFactory {
    private static final Faker faker = new Faker();

    public static Order generateOrder(long petId) {
        Order order = new Order();
        order.setId(faker.number().positive());
        order.setPetId(petId);
        order.setQuantity(faker.number().numberBetween(1, 10));
        order.setShipDate(OffsetDateTime.now(ZoneOffset.UTC));
        order.setStatus("placed");
        order.setComplete(false);
        return order;
    }
}
