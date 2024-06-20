package pl.restassured.tests.user;

import org.testng.annotations.Test;
import pl.restassured.main.pojo.user.User;
import pl.restassured.tests.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class CreateUserTest extends TestBase {

    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {
        User user = User.builder()
                .id(445)
                .username("john")
                .firstName("John")
                .lastName("Doe")
                .email("johndoe")
                .password("secret")
                .phone("123456789")
                .userStatus(123)
                .build();

        given().body(user)
                .when().post("user")
                .then().statusCode(200);
    }
}
