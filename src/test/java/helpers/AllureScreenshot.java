package helpers;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AllureScreenshot {

    public static void captureGraph() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get(new File("allure-report/index.html").toURI().toString());

            // Better: wait for the chart container to appear (if you know the element ID or class)
            Thread.sleep(2000); // Use WebDriverWait in future

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("allure-report/chart.png");

            Files.move(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Optionally attach to Allure
            Allure.addAttachment("Allure Chart", Files.newInputStream(destination.toPath()));
        } catch (Exception e) {
            System.err.println("Failed to capture chart: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
