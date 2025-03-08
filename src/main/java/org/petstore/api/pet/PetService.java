package org.petstore.api.pet;

import io.restassured.response.Response;
import org.petstore.models.pet.Pet;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetService {

    private static final String BASE_PATH = "/pet";

    public Response createPet(Pet pet) {
        return given()
                .body(pet)
                .post(BASE_PATH);
    }

    public Response getPetById(long petId) {
        return given()
                .pathParam("petId", petId)
                .get(BASE_PATH + "/{petId}");
    }

    public Response updatePet(Pet pet) {
        return given()
                .body(pet)
                .put(BASE_PATH);
    }

    public Response deletePet(long petId) {
        return given()
                .pathParam("petId", petId)
                .delete(BASE_PATH + "/{petId}");
    }

    public Response findPetsByStatus(List<String> statuses) {
        return given()
                .queryParam("status", statuses)
                .get(BASE_PATH + "/findByStatus");
    }

    public Response uploadImage(long petId, String metadata, String filePath) {
        return given()
                .pathParam("petId", petId)
                .multiPart("additionalMetadata", metadata)
                .multiPart("file", new java.io.File(filePath))
                .post(BASE_PATH + "/{petId}/uploadImage");
    }
}
