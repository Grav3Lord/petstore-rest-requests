package org.petstore.util.factory.order;

import net.datafaker.Faker;
import org.petstore.models.order.Order;
import org.petstore.models.order.status.OrderStatus;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OrderFactory {
    private static final Faker faker = new Faker();

    public static Order generateOrder(int petId) {
        Order order = new Order();
        order.setId(faker.number().numberBetween(1, 10));
        order.setPetId(petId);
        order.setQuantity(faker.number().numberBetween(1, 10));
        order.setShipDate(OffsetDateTime.now(ZoneOffset.UTC).toString());
        OrderStatus[] statuses = OrderStatus.values();
        order.setStatus(statuses[faker.random().nextInt(statuses.length)]);
        order.setComplete(faker.bool().bool());
        return order;
    }
}
