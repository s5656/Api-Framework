import com.users.UserClient;
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
        String body="{\n" +
                "  \"name\": \"Aditi sharma\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Aditi.sharma.gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        userClient.createUSer(body)
                .then()
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))///////becouse there is no sign of data
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")))
                .log().body();

        ;
    }
}
