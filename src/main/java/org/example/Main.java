package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Main {
    @Test
    public void shouldGetAllUsers() {
        //1.Arrange
        //2.Act
        //3.Assert

        given()
                .when()
                    .get("https://gorest.co.in/public/v1/users")
                .then()
                    .statusCode(200)
                    .log().body();
    }
}