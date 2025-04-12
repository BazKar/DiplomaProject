package TestBase;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.linkedin.com"; // Укажи свой URL
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; // 10 секунд таймаут

        Configuration.reportsFolder = "allure-results";
        Configuration.browser = "chrome";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    void login() {
        open("/login");
        $("#username").setValue("kara.aim25@gmail.com");
        $("#password").setValue("karaB2005)");
        $("button[type='submit']").click();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        login();

        SelenideElement element = $("element-selector");  // Replace with actual element selector
        element.shouldBe(Condition.visible);
    }
    @AfterAll
    static void generateAllureReport() {
        try {
            Runtime.getRuntime().exec("allure generate build/allure-results --clean -o build/allure-report");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
