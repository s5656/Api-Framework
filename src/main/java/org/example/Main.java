package org.example;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
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
                    .body("data", Matchers.hasSize(10))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                    .log().body();
    }

    @Test
    public void shoudCreateUser(){
        given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization","Bearer d021d439eef6c8b55a0aab0366893a16d821ec3e2d2968432cadc6b197b18751")
                    .body("{\n" +
                        "  \"name\": \"Tenali Ramakrishna\",\n" +
                        "  \"gender\": \"male\",\n" +
                        "  \"email\": \"tenali.ramakrishna970@gmail.com\",\n" +
                        "  \"status\": \"active\"\n" +
                        "}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                    .log().body()
                    .statusCode(201)
                    .body("id", Matchers.notNullValue())
                    .body("email", Matchers.equalTo("tenali.ramakrishna970@gmail.com"));
    }
}