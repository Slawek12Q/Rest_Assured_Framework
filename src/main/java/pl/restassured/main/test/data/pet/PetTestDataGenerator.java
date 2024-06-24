package pl.restassured.main.test.data.pet;

import pl.restassured.main.pojo.pet.Category;
import pl.restassured.main.pojo.pet.Pet;
import pl.restassured.main.pojo.pet.Tag;
import pl.restassured.main.test.data.TestDataGenerator;

import java.util.Collections;
import java.util.Random;

public class PetTestDataGenerator extends TestDataGenerator {

    public Pet generatePet() {
        PetsCategory petsCategory = getRandomPetCategory();
        PetTags petTags = getRandomPetTag();
        PetStatus petStatus = getRandomPetStatus();

        return Pet.builder()
                .id(faker().number().numberBetween(1, 9999))
                .name(faker().animal().name())
                .category(Category.builder().id(petsCategory.getId()).name(petsCategory.getCategoryName()).build())
                .status(petStatus.getStatus())
                .photoUrls(Collections.singletonList(faker().internet().url()))
                .tags(Collections.singletonList(Tag.builder().id(petTags.getId()).name(petsCategory.getCategoryName()).build()))
                .build();
    }

    private PetsCategory getRandomPetCategory() {
        int index = new Random().nextInt(PetsCategory.values().length);
        return PetsCategory.values()[index];
    }

    private PetTags getRandomPetTag() {
        int index = new Random().nextInt(PetTags.values().length);
        return PetTags.values()[index];
    }

    private PetStatus getRandomPetStatus() {
        int index = new Random().nextInt(PetStatus.values().length);
        return PetStatus.values()[index];
    }
}
