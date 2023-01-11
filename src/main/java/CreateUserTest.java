import com.users.UserClient;
import create.CreateUserRequestBody;
import create.UserResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
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
        CreateUserRequestBody requestBody= CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna").gender("male").email(email).status("active").build();
        //Act
        UserResponse userResponse = userClient.createUser(requestBody);
        //Assert
        Assert.assertEquals(userResponse.getStatusCode(),201);
        Assert.assertNotNull(userResponse.getData().getId());
        Assert.assertEquals(userResponse.getData().getEmail(),requestBody.getEmail());

    }

    @Test
    public void shoudCreateFemaleUser(){
        //Arrenge
        String email= String.format("%s@gmail.com",UUID.randomUUID());
        CreateUserRequestBody requestBody= CreateUserRequestBody.builder()
                .name("Aditi sharma").gender("female").email(email).status("active").build();
        //Act
        //Act
        UserResponse userResponse = userClient.createUser(requestBody);
        //Assert
        Assert.assertEquals(userResponse.getStatusCode(),201);
        Assert.assertNotNull(userResponse.getData().getId());
        Assert.assertEquals(userResponse.getData().getEmail(),requestBody.getEmail());
    }
}
