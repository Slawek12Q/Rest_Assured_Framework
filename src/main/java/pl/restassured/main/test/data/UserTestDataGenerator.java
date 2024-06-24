package pl.restassured.main.test.data;

import pl.restassured.main.pojo.user.User;

public class UserTestDataGenerator extends TestDataGenerator {

    public User generateUser() {
        return User.builder()
                .id(faker().number().numberBetween(1, 9999))
                .username(faker().name().username())
                .firstName(faker().name().firstName())
                .lastName(faker().name().lastName())
                .email(faker().internet().emailAddress())
                .password("Password123")
                .phone(faker().phoneNumber().cellPhone())
                .userStatus(1)
                .build();
    }
}
