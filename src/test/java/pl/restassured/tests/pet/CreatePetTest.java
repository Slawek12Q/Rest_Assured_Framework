package pl.restassured.tests.pet;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.restassured.main.pojo.Category;
import pl.restassured.main.pojo.Pet;
import pl.restassured.main.pojo.Tag;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreatePetTest {

    @BeforeMethod
    public void setupConfiguration() {
        RestAssured.baseURI = "https://swaggerpetstore.przyklady.javastart.pl";
        RestAssured.basePath = "/v2";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json").build();
    }

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
