package pl.restassured.tests.pet;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pl.restassured.main.pojo.pet.Pet;
import pl.restassured.main.test.data.pet.PetTestDataGenerator;
import pl.restassured.tests.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreatePetTest extends TestBase {

    Faker faker = new Faker();

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        PetTestDataGenerator petTestDataGenerator = new PetTestDataGenerator();
        Pet pet = petTestDataGenerator.generatePet();

        Pet acctualPet = given().body(pet)
                .post("/pet")
                .then().statusCode(200).extract().as(Pet.class);

        assertEquals(acctualPet.getId(), pet.getId());
        assertEquals(acctualPet.getName(), pet.getName());
        assertEquals(acctualPet.getCategory().getName(), pet.getCategory().getName());
        assertEquals(acctualPet.getTags().get(0).getName(), pet.getTags().get(0).getName());
    }
}
