package api.specs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
public class BaseSpecs {
        public static RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")  // Change to your API URL
                .setContentType("application/json")
                .build();
    }

