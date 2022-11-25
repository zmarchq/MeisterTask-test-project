package tests.api;

import api.steps.UserSteps;
import helpers.TestDataFaker;
import api.request.AuthBody;
import api.response.AuthError;
import api.models.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
public class ApiTest extends TestBase {
    UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("All registered users have email")
    void checkEmailIsNotEmpty() {
        userSteps
                .getListOfUsers()
                .getUserData()
                .forEach(user -> assertThat(user.getEmail()).isNotEmpty());
    }

    @Test
    @DisplayName("Unsuccessful registration error")
    void CheckRegisterValidationError() {
        AuthBody authBody = new AuthBody(TestDataFaker.fullname,
                TestDataFaker.password);

        AuthError authError = userSteps.getAuthError(authBody);

        assertThat(authError.getError())
                .isEqualTo("Note: Only defined users " +
                        "succeed registration");
    }

    @Test
    @DisplayName("date the user's data was last updated")
    void checkUserIsUpdated() {
        int id = userSteps.getUserId();
        UserData userData = new UserData();
        userData.setEmail(TestDataFaker.email);
        userData.setFirstName(TestDataFaker.firstname);
        UserData data = userSteps.updateUser(userData, id);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDate = simpleDateFormat.format(new Date());

        assertThat(data.getCreatedAt()).contains(expectedDate);
    }
}
