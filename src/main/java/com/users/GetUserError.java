package com.users;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GetUserError {
    @Setter
    private int statusCode;
    private Data data;

    private String meta;

    public void assertError(int expextedStatusCode,String expectedErrorMassage) {
        Assert.assertEquals(statusCode,expextedStatusCode);
        Assert.assertEquals(data.massege,expectedErrorMassage);
    }

    @Getter
    public static class Data{
        private String massege;
    }
}
