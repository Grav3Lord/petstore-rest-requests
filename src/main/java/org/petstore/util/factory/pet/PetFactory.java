package org.petstore.util.factory.pet;

import net.datafaker.Faker;
import org.petstore.models.pet.Pet;
import org.petstore.models.pet.category.Category;
import org.petstore.models.pet.tag.Tag;

import java.util.Collections;
import java.util.List;

public class PetFactory {
    private static final Faker faker = new Faker();

    public static Pet generatePet() {
        Category category = new Category(faker.number().randomNumber(), faker.animal().name());
        List<String> photoUrls = Collections.singletonList(faker.internet().url());
        List<Tag> tags = Collections.singletonList(new Tag(faker.number().numberBetween(1, 3), faker.color().name()));

        Pet pet = new Pet();
        pet.setId(faker.number().numberBetween(1, 10));
        pet.setCategory(category);
        pet.setName(faker.name().firstName());
        pet.setPhotoUrls(photoUrls);
        pet.setTags(tags);
        pet.setStatus("available");
        return pet;
    }
}
