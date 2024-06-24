package pl.restassured.main.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateResponse {

    private Integer code;
    private String type;
    private String message;
}
