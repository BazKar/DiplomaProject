package api.tests;

import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import api.specs.RequestSpecs;
import api.specs.ResponseSpecs;
import api.utils.AllureRestAssuredListener;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {
    @Test
    void createUserTest() {
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Karashash");
        request.setJob("QA Engineer");

        CreateUserResponse response = given()
                .spec(RequestSpecs.baseRequestSpec)
                .filter(AllureRestAssuredListener.withCustomTemplates())
                .body(request)
                .when()
                .post("/users")
                .then()
                .spec(ResponseSpecs.responseSpecCreated)
                .extract().as(CreateUserResponse.class);

        System.out.println("Created user: " + response.getId());
    }
}
