package pages.web;

import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    @Step("Open main page")
    public MainPage openPage() {
        open("https://www.meistertask.com/ru");
        return this;
    }

    @Step("Click Sign Up")
    public RegistrationPage clickSignUp() {
        $(Selectors.byText("Зарегистрироваться")).click();
        return new RegistrationPage();
    }
}
