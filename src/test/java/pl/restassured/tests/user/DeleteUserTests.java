package pl.restassured.tests.user;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.restassured.main.rop.DeleteUserEndpoint;
import pl.restassured.tests.testbase.TestBase;

public class DeleteUserTests extends TestBase {

    String username;

    @BeforeTest
    public void beforeTest() {
        username = new Faker().name().username();
        new DeleteUserEndpoint().setUsername(username).sendRequest();
    }

    @Test
    public void givenNonExistingUserWhenDeletingUserThenUserNotFoundTest() {
        new DeleteUserEndpoint().setUsername(username).sendRequest().assertStatusCode(HttpStatus.SC_NOT_FOUND);
    }
}
