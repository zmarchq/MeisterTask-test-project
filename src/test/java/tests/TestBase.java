package tests;

import configs.ConfigRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    private static final ConfigRunner runner = new ConfigRunner();

    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide());
        runner.runBeforeAllPlatformConfiguration();
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void addAttachments() {
        runner.runAfterEachPlatformConfig();
    }
}
