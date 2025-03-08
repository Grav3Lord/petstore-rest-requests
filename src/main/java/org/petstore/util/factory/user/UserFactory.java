package org.petstore.util.factory.user;

import net.datafaker.Faker;
import org.petstore.models.user.User;

public class UserFactory {

    private static final Faker faker = new Faker();

    public static User generateUser() {
        User user = new User();
        user.setId(faker.number().randomNumber());
        user.setUsername(faker.internet().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setUserStatus(1);
        return user;
    }
}
