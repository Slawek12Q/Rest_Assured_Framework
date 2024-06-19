package pl.restassured.main.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {

    private Integer id;
    private String name;
}