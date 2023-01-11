package create;

import lombok.Getter;
import lombok.Setter;
@Getter
public class UserResponse {
    @Setter
    private int statusCode;
    private String meta;
    private Data data;
}
