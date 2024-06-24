package pl.restassured.main.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

    private Integer code;
    private String type;
    private String message;
}
