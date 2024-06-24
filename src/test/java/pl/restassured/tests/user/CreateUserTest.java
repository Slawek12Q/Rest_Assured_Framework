package pl.restassured.tests.user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pl.restassured.main.pojo.UserCreateResponse;
import pl.restassured.main.pojo.user.User;
import pl.restassured.main.test.data.UserTestDataGenerator;
import pl.restassured.tests.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateUserTest extends TestBase {

    private User user;
    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {

        UserTestDataGenerator userTestDataGenerator = new UserTestDataGenerator();
        user = userTestDataGenerator.generateUser();

        UserCreateResponse response = given().body(user)
                .when().post("user")
                .then().statusCode(200).extract().as(UserCreateResponse.class);

        assertEquals(response.getCode(), 200);
        assertEquals(response.getType(), "unknown");
        assertEquals(response.getMessage(), user.getId().toString());
    }

    @AfterMethod
    public void cleanUpAfterTest() {
        UserCreateResponse response = given()
                .when().delete("user/" + user.getUsername())
                .then().statusCode(200).extract().as(UserCreateResponse.class);

        assertEquals(response.getCode(), 200);
        assertEquals(response.getType(), "unknown");
        assertEquals(response.getMessage(), user.getUsername());
    }
}
