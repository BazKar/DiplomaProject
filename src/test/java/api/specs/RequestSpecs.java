package api.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestSpecs {
    public static RequestSpecification baseRequestSpec = given()
            .baseUri("https://www.linkedin.com")
            .contentType("application/json")
            .log().all();
}
