package pages.web;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    @Step("Enter username")
    public RegistrationPage setUsername(String username) {
        $("#sign_up_email_name").sendKeys(username);
        return this;
    }

    @Step("Enter email")
    public RegistrationPage setEmail(String email) {
        $("#sign_up_email_email").sendKeys(email);
        return this;
    }

    @Step("Set password")
    public RegistrationPage setPassword(String password) {
        $("#sign_up_email_password").sendKeys(password);
        return this;
    }

    @Step("Check privacy policy")
    public RegistrationPage checkPrivacyPolicy() {
        $("#sign_up_email_terms_of_service").click();
        return this;
    }

    @Step("Submit")
    public ConfirmationPage submit() {
        $("#btn_signin").click();
        return new ConfirmationPage();
    }
}
