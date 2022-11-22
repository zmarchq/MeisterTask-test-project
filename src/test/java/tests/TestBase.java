package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.web.WebDriverConfiguration;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        WebDriverConfiguration webDriverConfiguration = new WebDriverConfiguration();
        webDriverConfiguration.configure();
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("LastScreenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs(); //Не работает с firefox!
        Attach.addVideo();
    }
}
