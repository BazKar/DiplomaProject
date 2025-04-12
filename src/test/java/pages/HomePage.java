package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private SelenideElement name = $("body"); // You can adjust the selector if needed
    private SelenideElement title = $("body"); // Adjust if it's a more specific container
    private SelenideElement navigation = $(".global-nav");

    // Method to check if the name is visible
    public HomePage checkNameIsVisible(String expectedName) {
        name.shouldHave(text(expectedName));
        return this; // for method chaining
    }

    // Method to check if the title is visible
    public HomePage checkTitleIsVisible(String expectedTitle) {
        title.shouldHave(text(expectedTitle));
        return this; // for method chaining
    }

    // Method to check if the navigation bar is visible
    public HomePage navigationsIsVisible() {
        navigation.shouldBe(visible);
        return this; // for method chaining
    }

}
