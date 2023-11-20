package api;

import dto.ApiUserPage;
import io.qameta.allure.Step;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";

    @Step("delete user")
    public static Response delete(String token) {
        return given()
                .baseUri(BASE_URI)
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter())
                .header("Authorization", token)
                .when()
                .delete("api/auth/user");
    }

    @Step("authorization")
    public static Response login(ApiUserPage apiUserPage) {
        return given()
                .baseUri(BASE_URI)
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter())
                .header("Content-type", "application/json")
                .and()
                .body(apiUserPage)
                .when()
                .post("api/auth/login");
    }

    @Step("registration")
    public static Response registration(ApiUserPage apiUserPage) {
        return given()
                .baseUri(BASE_URI)
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter())
                .header("Content-type", "application/json")
                .body(apiUserPage)
                .when()
                .post("api/auth/register");
    }
}