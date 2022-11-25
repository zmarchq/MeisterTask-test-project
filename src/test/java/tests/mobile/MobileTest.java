package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.mobile.OnboardPage;
import pages.mobile.SearchPage;
import tests.TestBase;

@Tag("mobile")
public class MobileTest extends TestBase {
    @Test
    @DisplayName("Keyword Search on Wiki")
    void androidTest() {
        new SearchPage()
                .searchContent("QA")
                .checkContentIsNotEmpty();
    }

    @Test
    @DisplayName("Open article")
    void openArticle() {
        new SearchPage()
                .searchContent("Appium")
                .checkContentIsDisplayed();
    }

    @Test
    @DisplayName("Check OnBoarding flow")
    void checkSetupFlow() {
        new OnboardPage()
                .isEnabled(OnboardPage.LANG_OPTION)
                .clickNext()
                .hasText(OnboardPage.WELCOME_TEXT,
                        "New ways to explore")
                .clickNext()
                .isEnabled(OnboardPage.WELCOME_IMAGE)
                .clickNext()
                .isNotChecked(OnboardPage.AGREEMENT);
    }
}
