package com.users;

import create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

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
    public static Response getAll() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response.then().log().body();
        return response;
    }

    public Response get(int id) {
        Response response= given()
                .pathParam("id", id)
                .when()
                .get("https://gorest.co.in/public/v1/users/{id}");
        response.then().log().body();

        return response;
    }

    public Response delete(int id) {
        Response response= given()
                .pathParam("id", id)
                .header("Authorization", "Bearer d021d439eef6c8b55a0aab0366893a16d821ec3e2d2968432cadc6b197b18751")
                .when()
                .delete("https://gorest.co.in/public/v1/users/{id}");
        response.then().log().body();

        return response;
    }
}
