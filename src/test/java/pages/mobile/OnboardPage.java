package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OnboardPage {

    public static final SelenideElement LANG_OPTION = $(AppiumBy.id("org.wikipedia.alpha:id/option_label")),
    WELCOME_TEXT = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")),
    WELCOME_IMAGE = $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered")),
    AGREEMENT = $(AppiumBy.id("org.wikipedia.alpha:id/switchView"));


    @Step("Click on the Next btn")
    public OnboardPage clickNext(){
        $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        return this;
    }

    @Step("Check if element is enabled")
    public OnboardPage isEnabled(SelenideElement element) {
        element.shouldHave(enabled);
        return this;
    }

    @Step("Check if switchView is checked")
    public OnboardPage isNotChecked(SelenideElement element) {
        element.shouldHave(not(checked));
        return this;
    }

    @Step("Check if field has expected text")
    public OnboardPage hasText(SelenideElement element, String text) {
        element.shouldHave(text(text));
        return this;
    }
}
