package pl.restassured.main.test.data.pet;

import lombok.Getter;

@Getter
public enum PetsCategory {

    DOGS(1, "dogs"),
    CATS(2, "cats"),
    OTHER(3, "other");

    private int id;
    private String categoryName;

    PetsCategory(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
