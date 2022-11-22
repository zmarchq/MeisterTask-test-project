package tests;

import api.UserSteps;
import com.github.javafaker.Faker;
import models.AuthBody;
import models.AuthError;
import models.UserData;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTest extends TestBase {

    static Faker faker = new Faker();
    UserSteps userSteps = new UserSteps();

    @Test
    void checkEmailIsNotEmpty() {
        userSteps
                .getListOfUsers()
                .getUserData()
                .forEach(user -> assertThat(user.getEmail()).isNotEmpty());
    }

    @Test
    void CheckRegisterValidationError() {
        AuthBody authBody = new AuthBody(
                faker.internet().emailAddress(),
                faker.internet().password());

        AuthError authError = userSteps.getAuthError(authBody);

        assertThat(authError.getError())
                .isEqualTo("Note: Only defined users " +
                        "succeed registration");
    }

    @Test
    void checkUserIsUpdated() {
        int id = userSteps.getUserId();
        UserData userData = new UserData();
        userData.setEmail(faker.internet().emailAddress());
        userData.setFirstName(faker.name().firstName());
        UserData data = userSteps.updateUser(userData, id);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDate = simpleDateFormat.format(new Date());

        assertThat(data.getCreatedAt()).contains(expectedDate);
    }
}
