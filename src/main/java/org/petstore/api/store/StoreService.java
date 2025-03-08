package org.petstore.api.store;

import io.restassured.response.Response;
import org.petstore.models.order.Order;

import static io.restassured.RestAssured.given;

public class StoreService {
    private static final String BASE_PATH = "/store";

    public Response placeOrder(Order order) {
        return given()
                .body(order)
                .post(BASE_PATH + "/order");
    }

    public Response getOrderById(long orderId) {
        return given()
                .pathParam("orderId", orderId)
                .get(BASE_PATH + "/order/{orderId}");
    }

    public Response deleteOrder(long orderId) {
        return given()
                .pathParam("orderId", orderId)
                .delete(BASE_PATH + "/order/{orderId}");
    }

    public Response getInventory() {
        return given()
                .get(BASE_PATH + "/inventory");
    }
}
