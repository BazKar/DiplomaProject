package api.utils;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureRestAssuredListener {
    public static AllureRestAssured withCustomTemplates() {
        return new AllureRestAssured()
                .setRequestTemplate("http-request.ftl")
                .setResponseTemplate("http-response.ftl");
    }
}
