package pl.restassured.main.test.data.pet;

import lombok.Getter;

@Getter
public enum PetStatus {

    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String status;

    PetStatus(String status) {
        this.status = status;
    }
}
