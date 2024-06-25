package pl.restassured.tests.pet;

import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pl.restassured.main.pojo.ApiResponse;
import pl.restassured.main.pojo.pet.Pet;
import pl.restassured.main.rop.CreatePetEndpoint;
import pl.restassured.main.test.data.pet.PetTestDataGenerator;
import pl.restassured.tests.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreatePetTest extends TestBase {

    private Pet actualPet;

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        Pet pet = new PetTestDataGenerator().generatePet();

        actualPet = new CreatePetEndpoint().setPet(pet).sendRequest().assertRequestSuccess().getResponseModel();

//        Pet actualPet = given().body(pet)
//                .post("/pet")
//                .then().statusCode(200).extract().as(Pet.class);

        Assertions.assertThat(actualPet).describedAs("Created pet is different than actual").usingRecursiveComparison().isEqualTo(pet);
    }

    @AfterMethod
    public void cleanUpAfterTest() {
        ApiResponse response = given()
                .when().delete("/pet/" + actualPet.getId())
                .then().statusCode(200).extract().as(ApiResponse.class);

        assertEquals(response.getCode(), 200);
        assertEquals(response.getType(), "unknown");
        assertEquals(response.getMessage(), actualPet.getId().toString());
    }
}
