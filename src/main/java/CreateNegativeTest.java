import com.users.UserClient;
import create.CreateUserRequestBody;
import create.UserResponse;
import lombok.Builder;
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
      CreateUserRequestBody requestBody= CreateUserRequestBody.builder()
                        .name("Aditi sharma").gender("female")
                        .email("Aditi.sharma.gmail.com").status("active").build();


        userClient.create(requestBody)
                .then()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")))
                .log().body();
    }
}
