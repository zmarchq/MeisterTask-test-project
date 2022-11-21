package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    @Step("Enter username")
    public RegistrationPage setUsername() {
        $("#sign_up_email_name").sendKeys("Evgeny Grishaev");
        return this;
    }

    @Step("Enter email")
    public RegistrationPage setEmail() {
        $("#sign_up_email_email").sendKeys("EvgenyGrishaev99@gmail.com");
        return this;
    }

    @Step("Set password")
    public RegistrationPage setPassword() {
        $("#sign_up_email_password").sendKeys("Terdg2235456!&");
        return this;
    }

    @Step("Check privacy policy")
    public RegistrationPage checkPrivacyPolicy() {
       // $("#sign_up_email[terms_of_service]").click();
        System.out.println($("#sign_up_email[terms_of_service]"));
        return this;
    }

    @Step("Submit")
    public ConfirmationPage submit() {
       // $("btn_signin").click();
        System.out.println($("btn_signin"));
        return new ConfirmationPage();
    }
}
