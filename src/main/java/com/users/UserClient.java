package com.users;

import create.CreateUserRequestBody;
import create.UserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public static UserResponse createUser(CreateUserRequestBody requestBody) {
        Response response = create(requestBody);
        UserResponse userResponse=response.as(UserResponse.class);
        userResponse.setStatusCode(response.statusCode());
        return userResponse;

    }

    public static Response create(CreateUserRequestBody requestBody) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer d021d439eef6c8b55a0aab0366893a16d821ec3e2d2968432cadc6b197b18751")
                .body(requestBody)
                .when()
                .post("https://gorest.co.in/public/v1/users");

            response.then().log().body();
        return response;
    }

    public static Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }
}
