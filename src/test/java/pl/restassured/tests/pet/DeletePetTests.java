package pl.restassured.tests.pet;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import pl.restassured.main.rop.DeletePetEndpoint;
import pl.restassured.tests.testbase.TestBase;

public class DeletePetTests extends TestBase {

    private int nonExistingPetId;
    @Test
    public void givenNonExistingPetWhenDeletingPetThenPetNotFoundTest() {
        nonExistingPetId = new Faker().number().numberBetween(1000, 10000);

        new DeletePetEndpoint().setPetId(nonExistingPetId).sendRequest().assertStatusCode(HttpStatus.SC_NOT_FOUND);
    }

}
