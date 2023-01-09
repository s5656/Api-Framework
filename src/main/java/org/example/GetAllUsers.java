package org.example;

import com.users.UserClient;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllUsers {

    private UserClient userClient;
    @BeforeClass
    public void setUserClient(){
        userClient=new UserClient();
    }
    @Test
    public void shouldGetAllUsers() {
        //1.Arrange
        //2.Act
        //3.Assert

        userClient.getAllUsers()
                .then()
                    .statusCode(200)
                    .body("data", Matchers.hasSize(10))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                    .log().body();
    }



}