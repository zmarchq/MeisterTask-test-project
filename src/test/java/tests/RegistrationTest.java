package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.web.MainPage;

@Tag("web")
public class RegistrationTest extends TestBase {

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
