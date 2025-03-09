package users;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.petstore.service.user.UserService;
import org.petstore.config.rest.Config;
import org.petstore.models.user.User;
import org.petstore.util.factory.user.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {

    private static UserService users;

    @BeforeAll
    static void setup() {
        Config.setup();
        users = new UserService();
    }

    @Test
    void testCreateAndGetUser() {
        User user = UserFactory.generateUser();

        users.createUser(user)
                .then()
                .statusCode(200);

        User responseUser = users.getUserByName(user.getUsername())
                .then()
                .statusCode(200)
                .extract().as(User.class);

        assertThat(responseUser.getUsername(), equalTo(user.getUsername()));
        assertThat(responseUser.getEmail(), equalTo(user.getEmail()));
    }

    @Test
    void testUpdateUser() {
        User user = UserFactory.generateUser();
        users.createUser(user)
                .then()
                .statusCode(200);

        user.setFirstName("UpdatedName");
        user.setLastName("UpdatedLastName");

        users.updateUser(user.getUsername(), user)
                .then()
                .statusCode(200);

        User updatedUser = users.getUserByName(user.getUsername())
                .then()
                .statusCode(200)
                .extract().as(User.class);

        assertThat(updatedUser.getFirstName(), equalTo("UpdatedName"));
        assertThat(updatedUser.getLastName(), equalTo("UpdatedLastName"));
    }

    @Test
    void testDeleteUser() {
        User user = UserFactory.generateUser();
        users.createUser(user)
                .then()
                .statusCode(200);

        users.deleteUser(user.getUsername())
                .then()
                .statusCode(200);

        users.getUserByName(user.getUsername())
                .then()
                .statusCode(404);
    }
}
