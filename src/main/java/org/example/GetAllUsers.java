package org.example;

import com.users.UserClient;
import org.testng.Assert;
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

        com.users.GetAllUsers allUsers = userClient.getAllUsers();
        Assert.assertEquals(allUsers.getStatusCode(),200);
        Assert.assertEquals(allUsers.getDataList().size(),10);
        Assert.assertTrue(allUsers.hasMaleUsers());
    }



}