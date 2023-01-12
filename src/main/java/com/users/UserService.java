package com.users;

import create.CreateUserRequestBody;
import create.GetUserErrorResponse;
import create.UserResponse;
import io.restassured.response.Response;

public class UserService {
    public UserResponse createUser(CreateUserRequestBody requestBody) {
        Response response = new UserClient().create(requestBody);
        UserResponse userResponse=response.as(UserResponse.class);
        userResponse.setStatusCode(response.statusCode());
        return userResponse;

    }
    public GetUserErrorResponse userErrorResponse(CreateUserRequestBody requestBody){
        Response response=new UserClient().create(requestBody);
        GetUserErrorResponse errorResponse=response.as(GetUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }
    public GetUserResponse getUser(int id){
        Response response = new UserClient().get(id);
        int statusCode=response.statusCode();

        GetUserResponse getUserResponse=response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
        return getUserResponse;
    }
    public GetAllUsers getAllUsers() {
        Response response = new UserClient().getAll();

        int statusCode = response.statusCode();
        GetAllUsers getAllUsers=response.as(GetAllUsers.class);
        getAllUsers.setStatusCode(statusCode);
        return getAllUsers;
    }
    public int deleteUser(int id){
        Response response = new UserClient().delete(id);
        return response.statusCode();
    }
    public GetUserError getUserExpectingError(int id){
        Response response = new UserClient().get(id);
        int statusCode=response.statusCode();

        GetUserError userErrorResponse=response.as(GetUserError.class);
        userErrorResponse.setStatusCode(statusCode);
        return userErrorResponse;
    }
}
