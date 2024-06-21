package pl.restassured.main.pojo.pet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private Integer id;
    private String name;

}