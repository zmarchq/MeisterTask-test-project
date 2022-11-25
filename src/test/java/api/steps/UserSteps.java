package api.steps;

import api.steps.Specs;
import io.qameta.allure.Step;
import api.request.AuthBody;
import api.response.AuthError;
import api.models.UserData;
import api.response.UserListResponse;

import static configs.api.ApiPath.User.*;

public class UserSteps extends Specs {

    @Step("Get list of users")
    public UserListResponse getListOfUsers() {
        return givenSpec(USERS)
                .get()
                .then()
                .spec(respSpec(200))
                .extract().body().as(UserListResponse.class);
    }

    @Step("Register with undefined user")
    public AuthError getAuthError(AuthBody authBody) {
        return givenSpec(REGISTER)
                .body(authBody)
                .post()
                .then()
                .spec(respSpec(400))
                .extract().body().as(AuthError.class);
    }

    @Step("Update user data")
    public UserData updateUser(UserData userData, int id) {
        return givenSpec(USER + id)
                .body(userData)
                .post()
                .then()
                .spec(respSpec(201))
                .extract().body().as(UserData.class);
    }

    @Step("Get user id")
    public int getUserId() {
        return getListOfUsers().getUserData().get(0).getId();
    }
}
