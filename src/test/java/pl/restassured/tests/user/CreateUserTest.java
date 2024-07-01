package pl.restassured.tests.user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pl.restassured.main.pojo.ApiResponse;
import pl.restassured.main.pojo.user.User;
import pl.restassured.main.rop.CreateUserEndpoint;
import pl.restassured.main.rop.DeleteUserEndpoint;
import pl.restassured.main.test.data.UserTestDataGenerator;
import pl.restassured.tests.testbase.TestBase;

import static org.testng.Assert.assertEquals;

public class CreateUserTest extends TestBase {

    private User user;
    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {
        user = new UserTestDataGenerator().generateUser();

        ApiResponse response = new CreateUserEndpoint().setUser(user).sendRequest().assertRequestSuccess().getResponseModel();

        assertEquals(response.getCode(), 200);
        assertEquals(response.getType(), "unknown");
        assertEquals(response.getMessage(), user.getId().toString());
    }

    @AfterMethod
    public void cleanUpAfterTest() {
        ApiResponse response = new DeleteUserEndpoint().setUsername(user.getUsername()).sendRequest().assertRequestSuccess().getResponseModel();

        assertEquals(response.getCode(), 200);
        assertEquals(response.getType(), "unknown");
        assertEquals(response.getMessage(), user.getUsername());
    }
}
