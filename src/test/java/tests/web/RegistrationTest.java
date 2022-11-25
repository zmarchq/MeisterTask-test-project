package tests.web;

import helpers.TestDataFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.web.MainPage;
import pages.web.TrialPage;
import tests.TestBase;

@Tag("web")
public class RegistrationTest extends TestBase {
    @Test
    @DisplayName("Register new user")
    void register() {
        new MainPage()
                .openPage()
                .clickSignUp()
                .setUsername(TestDataFaker.fullname)
                .setEmail(TestDataFaker.email)
                .setPassword(TestDataFaker.password)
                .checkPrivacyPolicy()
                .submit()
                .resendButtonIsEnable();
    }

    @Test
    @DisplayName("Check descriptions of plans")
    void checkPlans() {
         new MainPage()
                .openPage()
                .clickPrice()
                .checkPlans("Базовый",
                        "Базовые функции для одиночного управления задачами")
                 .checkPlans("Про",
                         "Простое совместное управление задачами для команд");
    }

    @Test
    @DisplayName("Trial form validation")
    void testRequestTrialValidation() {
        new TrialPage()
                .openPage()
                .setFirstname(TestDataFaker.firstname)
                .setLastname(TestDataFaker.lastname)
                .setEmail(TestDataFaker.email)
                .submit()
                .checkValidationMessage("Введите действительный адрес электронной почты");
    }
}
