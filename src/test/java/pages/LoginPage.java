package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public LoginPage openPage() {
        open("/login");  // Используем baseUrl из TestBase
        return this;
    }

    public LoginPage enterUsername(String username) {
        $("#username").setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        $("button[type='submit']").click();
        sleep(10000);
        return this;
    }

    public void checkProfileName(String expectedName) {
        $("h3.profile-card-name.text-heading-large").shouldHave(text(expectedName));
    }
}
