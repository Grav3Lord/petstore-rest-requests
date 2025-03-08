package org.petstore.api.user;

import io.restassured.response.Response;
import org.petstore.models.user.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService {

    private static final String BASE_PATH = "/user";

    public Response createUser(User user) {
        return given()
                .body(user)
                .post(BASE_PATH);
    }

    public Response createUsersWithList(List<User> users) {
        return given()
                .body(users)
                .post(BASE_PATH + "/createWithList");
    }

    public Response getUserByName(String username) {
        return given()
                .pathParam("username", username)
                .get(BASE_PATH + "/{username}");
    }

    public Response updateUser(String username, User user) {
        return given()
                .pathParam("username", username)
                .body(user)
                .put(BASE_PATH + "/{username}");
    }

    public Response deleteUser(String username) {
        return given()
                .pathParam("username", username)
                .delete(BASE_PATH + "/{username}");
    }

    public Response loginUser(String username, String password) {
        return given()
                .queryParam("username", username)
                .queryParam("password", password)
                .get(BASE_PATH + "/login");
    }

    public Response logoutUser() {
        return given()
                .get(BASE_PATH + "/logout");
    }
}
