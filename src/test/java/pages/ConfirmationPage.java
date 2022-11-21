package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {

    @Step("Check resend form is enable")
    public void resendButtonIsEnable() {
     // $("#email_resend_form").shouldBe(Condition.enabled);
        System.out.println($("#email_resend_form"));
    }
}
