package pl.restassured.tests.testbase;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeSuite;
import pl.restassured.main.properties.EnvironmentConfig;

public class TestBase {

    @BeforeSuite
    public void setupConfiguration() {
        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        RestAssured.baseURI = environmentConfig.baseUri();
        RestAssured.basePath = environmentConfig.basePath();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).build();
    }
}
