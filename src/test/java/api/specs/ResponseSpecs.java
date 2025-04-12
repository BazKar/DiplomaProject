package api.specs;

import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseSpecs {
    public static ResponseSpecification responseSpecCreated = expect()
            .statusCode(201)  // We expect status code 201 (Created)
            .contentType("application/json");
    public static ResponseSpecification responseSpecOK = expect()
            .statusCode(404)
            .contentType("text/html");

}
