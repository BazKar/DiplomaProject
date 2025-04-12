package tests;

import TestBase.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;




public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    @Test
    @DisplayName("Successful login test")
    void LoginTest(){
        loginPage.openPage()
                .enterUsername("kara.aim25@gmail.com")
                .enterPassword("karaB2005)")
                .clickLoginButton()
                .checkProfileName("Karashash Bazargali");

    }
}
