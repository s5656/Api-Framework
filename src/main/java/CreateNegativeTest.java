import com.users.UserClient;
import create.CreateUserRequestBody;
import create.UserErrorResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNegativeTest {
    private UserClient userClient;
    @BeforeClass
    public void setUserClient(){
        userClient=new UserClient();
    }
    @Test
    public void notAllowInvalidEmail(){
      CreateUserRequestBody requestBody= CreateUserRequestBody.builder()
                        .name("Aditi sharma").gender("female")
                        .email("Aditi.sharma.gmail.com").status("active").build();

        UserErrorResponse response = userClient.userErrorResponse(requestBody);
        Assert.assertEquals(response.getStatusCode(),422);

        response.assertHasError("email","is invalid");
    }
    @Test
    public void notAllowBlankGenderAndStatus(){
        CreateUserRequestBody requestBody= CreateUserRequestBody.builder()
                .name("Aditi sharma").gender("")
                .email("Aditi.sharma@gmail.com").status("").build();

        UserErrorResponse response = userClient.userErrorResponse(requestBody);
        Assert.assertEquals(response.getStatusCode(),422);

        response.assertHasError("gender","can't be blank, can be male of female");
        response.assertHasError("status","can't be blank");
    }
}
