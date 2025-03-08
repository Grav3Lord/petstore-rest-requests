package pets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.petstore.api.pet.PetService;
import org.petstore.config.rest.Config;
import org.petstore.models.pet.Pet;
import org.petstore.util.factory.pet.PetFactory;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetsTest {

    private static PetService pets;

    @BeforeAll
    static void setup() {
        Config.setup();
        pets = new PetService();
    }

    @Test
    void testCreateAndGetPet() {
        Pet pet = PetFactory.generatePet();
        pets.createPet(pet)
                .then()
                .statusCode(200);

        Pet responsePet = pets.getPetById(pet.getId())
                .then()
                .statusCode(200)
                .extract().as(Pet.class);

        assertThat(responsePet.getName(), equalTo(pet.getName()));
    }

    @Test
    void testFindPetsByStatus() {
        pets.findPetsByStatus(Collections.singletonList("available"))
                .then()
                .statusCode(200);
    }
}
