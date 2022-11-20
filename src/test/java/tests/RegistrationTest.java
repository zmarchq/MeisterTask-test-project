package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

public class RegistrationTest {

    @Test
    void register() {
        new MainPage()
                .openPage()
                .clickSignUp()
                .setUsername()
                .setEmail()
                .setPassword()
                .checkPrivacyPolicy()
                .submit()
                .resendButtonIsEnable();
    }
}
