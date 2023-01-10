import com.users.UserClient;
import create.CreateUserRequestBody;
import org.hamcrest.Matchers;
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
        String name = "Aditi sharma";
        String gender = "female";
        String email = "Aditi.sharma.gmail.com";
        String status = "active";

        CreateUserRequestBody requestBody= new CreateUserRequestBody(name,gender,email,status);

        userClient.createUSer(requestBody)
                .then()
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))///////becouse there is no sign of data
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")))
                .log().body();
    }
}
