package tests;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

public class SearchTest extends TestBase {
    SearchPage searchPage = new SearchPage();
    @Test
    void SearchTest() {
        searchPage.enterLookingJobs("QA Engineer");
    }
}
