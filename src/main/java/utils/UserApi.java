package utils;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pageobject.RegisterPage;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    public static RequestSpecification getPostSpecAuth(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build()
                .given()
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter());
    }

    @Step("user delete")
    public static ValidatableResponse deleteUser(RegisterPage user, String token) {
        return given()
                .spec(getPostSpecAuth(token))
                .body(user)
                .when()
                .delete("/api/auth/user")
                .then();
    }

}