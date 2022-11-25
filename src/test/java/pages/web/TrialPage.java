package pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrialPage {

    @Step("Open Trial Page")
    public TrialPage openPage() {
        open("https://www.meistertask.com/pages/ru/request-trial");
        return this;
    }

    @Step("Set firstname {firstname}")
    public TrialPage setFirstname(String firstname) {
        Selenide.sleep(100000);
        $(Selectors.byName("firstname")).sendKeys(firstname);
        return this;
    }

    @Step("Set lastname {lastname}")
    public TrialPage setLastname(String lastname) {
        $("input[name=lastname]").sendKeys(lastname);
        return this;
    }

    @Step("Set email {email}")
    public TrialPage setEmail(String email) {
        $("input[name=email]").sendKeys(email);
        return this;
    }

    @Step("Click submit")
    public TrialPage submit() {
        $("input[type=submit]").click();
        return this;
    }

    @Step("Message {message} is displayed")
    public void checkValidationMessage(String message) {
        $("input[type=submit]").shouldHave(Condition.text(message));
    }
}
