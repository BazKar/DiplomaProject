package api.tests;

import api.specs.BaseSpecs;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest {
    @Test
    @Description("Get user by ID and verify response status")
    void getUserByIdTest() {
        given()
                .spec(BaseSpecs.requestSpec)
                .when()
                .get("/users/2")
                .then()
                .statusCode(200); // OK
    }

    @Test
    @Description("Delete user and check if it returns 204 No Content")
    void deleteUserTest() {
        given()
                .spec(BaseSpecs.requestSpec)
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204); // No Content
    }
}
