package api.tests;

import api.specs.RequestSpecs;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import api.specs.ResponseSpecs;
import static io.restassured.RestAssured.given;

public class GetUserTest {
    @Test
    @Description("Get user by ID and verify response structure")
    void getUserByIdTest() {
        given()
                .spec(RequestSpecs.baseRequestSpec)
                .when()
                .get("/users/2")
                .then()
                .spec(ResponseSpecs.responseSpecOK); // 200
    }
}
