package pl.restassured.main.pojo.pet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {

    private Integer id;
    private String name;
}
