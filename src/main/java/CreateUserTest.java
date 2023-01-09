import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {
    @Test
    public void shoudCreateMaleUser(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna1970@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        createUSer(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("tenali.ramakrishna1970@gmail.com"));
    }

    private static Response createUSer(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer d021d439eef6c8b55a0aab0366893a16d821ec3e2d2968432cadc6b197b18751")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }

    @Test
    public void shoudCreateFemaleUser(){
        //Arrenge
        String body = "{\n" +
                "  \"name\": \"Aditi sharma\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Aditi.sharma12@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        createUSer(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("Aditi.sharma12@gmail.com"));
    }

}
