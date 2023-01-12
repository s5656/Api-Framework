package create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetUserErrorResponse {
@Setter
    private int statusCode;
    private String meta;
    @JsonProperty("data")
    private List<Data> dataList;

    public void assertHasError(String filed, String message) {
        int size = dataList.stream()
                .filter(data -> data.getField().equals(filed))
                .filter(data -> data.getMessage().equals(message))
                .collect(Collectors.toList())
                .size();

        Assert.assertEquals(size,1);

    }

    @Getter
    public static class Data{
        private String field;
        private String message;

    }
}
