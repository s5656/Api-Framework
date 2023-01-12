import com.users.UserService;
import create.CreateUserRequestBody;
import create.GetUserErrorResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNegativeTest {
    private UserService userService;
    @BeforeClass
    public void setUserService(){
        userService =new UserService();
    }
    @Test
    public void notAllowInvalidEmail(){
      CreateUserRequestBody requestBody=new CreateUserRequestBody.Builder().email("Aditi.sharma.gmail.com").build();

        GetUserErrorResponse response = userService.userErrorResponse(requestBody);
        Assert.assertEquals(response.getStatusCode(),422);

        response.assertHasError("email","is invalid");
    }
    @Test
    public void notAllowBlankGenderAndStatus(){
        CreateUserRequestBody requestBody=new CreateUserRequestBody.Builder().gender("").status("").build();

        GetUserErrorResponse response = userService.userErrorResponse(requestBody);
        Assert.assertEquals(response.getStatusCode(),422);

        response.assertHasError("gender","can't be blank, can be male of female");
        response.assertHasError("status","can't be blank");
    }
}
