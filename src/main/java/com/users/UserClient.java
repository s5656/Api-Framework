package com.users;

import create.CreateUserRequestBody;
import create.UserErrorResponse;
import create.UserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public UserResponse createUser(CreateUserRequestBody requestBody) {
        Response response = create(requestBody);
        UserResponse userResponse=response.as(UserResponse.class);
        userResponse.setStatusCode(response.statusCode());
        return userResponse;

    }
public UserErrorResponse userErrorResponse(CreateUserRequestBody requestBody){
        Response response=create(requestBody);
        UserErrorResponse errorResponse=response.as(UserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }
    public Response create(CreateUserRequestBody requestBody) {
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

    public GetAllUsers getAllUsers() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");

                response.then().log().body();
        int statusCode = response.statusCode();
        GetAllUsers getAllUsers=response.as(GetAllUsers.class);
        getAllUsers.setStatusCode(statusCode);
        return getAllUsers;
    }
}
