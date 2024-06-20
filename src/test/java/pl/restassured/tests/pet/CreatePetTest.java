package pl.restassured.tests.pet;

import org.testng.annotations.Test;
import pl.restassured.main.pojo.pet.Category;
import pl.restassured.main.pojo.pet.Pet;
import pl.restassured.main.pojo.pet.Tag;
import pl.restassured.tests.testbase.TestBase;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreatePetTest extends TestBase {

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        Pet pet = Pet.builder()
                .id(111)
                .name("Dudus")
                .category(Category.builder().id(1).name("dogs").build())
                .status("available")
                .photoUrls(Collections.singletonList("http://photos.com/dog1.jpg"))
                .tags(Collections.singletonList(Tag.builder().id(1).name("dogs-category").build()))
                .build();

        Pet acctualPet = given().body(pet)
                .post("/pet")
                .then().statusCode(200).extract().as(Pet.class);

        assertEquals(acctualPet.getId(), 111);
        assertEquals(acctualPet.getName(), "Dudus");
    }
}
