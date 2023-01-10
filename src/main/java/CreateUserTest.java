import com.users.UserClient;
import create.CreateUserRequestBody;
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
        String name = "Tenali Ramakrishna";
        String gender = "male";
        String status = "active";

        CreateUserRequestBody requestBody= new CreateUserRequestBody(name,gender,email,status);
        //Act
        userClient.createUSer(requestBody)
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

        String name = "Aditi sharma";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody= new CreateUserRequestBody(name,gender,email,status);

        //Act
        new UserClient().createUSer(requestBody)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo(email));
    }
}
