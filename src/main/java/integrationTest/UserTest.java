package integrationTest;

import com.users.UserClient;
import com.users.UserService;
import create.CreateUserRequestBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {
    private UserService userService;
@BeforeClass
public void setUserService(){
        userService =new UserService();
    }
@Test
public void shoudCreateAndGetUser(){
    CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = userService.createUser(requestBody).getData().getId();
        //Assert
        userService.getUser(id).assertUser(requestBody);

    }

    @Test
    public void shoudDeletUser(){
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = userService.createUser(requestBody).getData().getId();
        //Assert
        int statuscode =userService.deleteUser(id);
        Assert.assertEquals(statuscode,204);
        userService.getUserExpectingError(id).assertError(404,"Resources not found");

    }

}
