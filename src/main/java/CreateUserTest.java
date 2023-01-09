import com.users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUserTest {
    private UserClient userClient;
    @BeforeClass
    public void setUserClient(){
        userClient=new UserClient();
    }
    @Test
    public void shoudCreateMaleUser(){
        String email= String.format("%s@gmail.com",UUID.randomUUID());
        //Arrange
        String body = String.format("{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \"active\"\n" +
                "}",email);
        //Act
        userClient.createUSer(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo(email));
    }

    @Test
    public void shoudCreateFemaleUser(){
        //Arrenge
        String email= String.format("%s@gmail.com",UUID.randomUUID());

        String body = String.format("{\n" +
                "  \"name\": \"Aditi sharma\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \"active\"\n" +
                "}",email);
        //Act
        new UserClient().createUSer(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo(email));
    }
}
