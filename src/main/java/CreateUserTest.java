import com.users.UserClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
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
                "  \"email\": \"tenali.ramakrishna1979@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        new UserClient().createUSer(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("tenali.ramakrishna1979@gmail.com"));
    }

    @Test
    public void shoudCreateFemaleUser(){
        //Arrenge
        String body = "{\n" +
                "  \"name\": \"Aditi sharma\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Aditi.sharma124@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        //Act
        new UserClient().createUSer(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("Aditi.sharma124@gmail.com"));
    }
}
