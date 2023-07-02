package org.example.client;

import io.restassured.response.ValidatableResponse;
import org.example.dto.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {
    public static final String USER_URL = "/api/auth/user";
    public static final String REGISTER_URL = "/api/auth/register";

    public ValidatableResponse register(CreateUserRequest createUserRequest) {
        return given()
                .spec(getSpec())
                .body(createUserRequest)
                .when()
                .post(REGISTER_URL)
                .then();
    }

    public ValidatableResponse delete(String token) {
        return given()
                .spec(getSpec())
                .header("Authorization", token)
                .when()
                .delete(USER_URL)
                .then();
    }
}
