package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    public SearchPage enterLookingJobs(String jobTitle){
        $("input[placeholder='Search']")
                .shouldBe(visible)
                .click();
        return this;
    }
}
