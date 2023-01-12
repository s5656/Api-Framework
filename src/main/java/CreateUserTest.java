import com.users.UserClient;
import com.users.UserService;
import create.CreateUserRequestBody;
import create.UserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserTest {
    private UserService userService;
    @BeforeClass
    public void setUserService(){
        userService = new UserService();
    }
    @Test
    public void shoudCreateMaleUser(){
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder()
                .gender("male").build();
        //Act
        UserResponse userResponse = userService.createUser(requestBody);
        //Assert
        userResponse.assertUser(requestBody);

    }

    @Test
    public void shoudCreateFemaleUser(){
        //Arrenge
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder()
                .gender("female").build();
        //Act
        UserResponse userResponse = userService.createUser(requestBody);
        //Assert
        userResponse.assertUser(requestBody);
    }
}
