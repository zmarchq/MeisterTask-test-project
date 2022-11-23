package api;

import io.qameta.allure.Step;
import models.AuthBody;
import models.AuthError;
import models.UserData;
import models.UserListResponse;

import static api.ApiPath.User.*;

public class UserSteps extends ApiConfiguration {

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
