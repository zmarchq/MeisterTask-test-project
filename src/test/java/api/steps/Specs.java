package api.steps;

import configs.api.ApiPath;
import helpers.CustomApiListener;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
    private static final Filter customAllureFilter = CustomApiListener.withCustomTemplates();

    public RequestSpecification givenSpec(String requestPath) {
        return RestAssured.given()
                .spec(reqSpec(requestPath));
    }


    private RequestSpecification reqSpec(String requestPath) {
        return with()
                .log().all()
                .filter(customAllureFilter)
                .baseUri(ApiPath.BASE_URI)
                .basePath(requestPath)
                .contentType(ContentType.JSON);
    }

    protected ResponseSpecification respSpec(int expectedCode) {
        return with()
                .log().all()
                .filter(customAllureFilter)
                .expect().statusCode(expectedCode);
    }
}
