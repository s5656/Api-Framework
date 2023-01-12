package org.example;

import com.users.UserClient;
import com.users.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllUsers {

    private UserService userService;
    @BeforeClass
    public void setUserClient(){
        userService =new UserService();
    }
    @Test
    public void shouldGetAllUsers() {
        com.users.GetAllUsers allUsers = userService.getAllUsers();
        Assert.assertEquals(allUsers.getStatusCode(),200);
        Assert.assertEquals(allUsers.getDataList().size(),10);
        Assert.assertTrue(allUsers.hasMaleUsers());
    }



}