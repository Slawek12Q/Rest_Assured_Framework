package pl.restassured.tests.pet;

import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pl.restassured.main.pojo.ApiResponse;
import pl.restassured.main.pojo.pet.Pet;
import pl.restassured.main.test.data.pet.PetTestDataGenerator;
import pl.restassured.tests.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreatePetTest extends TestBase {

    private Pet pet;

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        PetTestDataGenerator petTestDataGenerator = new PetTestDataGenerator();
        pet = petTestDataGenerator.generatePet();

        Pet actualPet = given().body(pet)
                .post("/pet")
                .then().statusCode(200).extract().as(Pet.class);

        Assertions.assertThat(actualPet).describedAs("Pet is not created").usingRecursiveComparison().isEqualTo(pet);
    }

    @AfterMethod
    public void cleanUpAfterTest() {
        ApiResponse response = given()
                .when().delete("/pet/" + pet.getId())
                .then().statusCode(200).extract().as(ApiResponse.class);

        assertEquals(response.getCode(), 200);
        assertEquals(response.getType(), "unknown");
        assertEquals(response.getMessage(), pet.getId().toString());
    }
}
