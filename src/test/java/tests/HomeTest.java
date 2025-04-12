package tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.HomePage;


public class HomeTest extends TestBase {
    HomePage homePage = new HomePage();

    @Test
    void checkNameIsVisible() {
        homePage.checkNameIsVisible("Karashash Bazargali");
    }

    @Test
    void checkTitleIsVisible() {
        homePage.checkTitleIsVisible("QA Automation");
    }

    @Test
    void navigationsIsVisible() {
        homePage.navigationsIsVisible();
    }
}
