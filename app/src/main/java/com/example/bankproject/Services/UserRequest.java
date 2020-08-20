package com.example.bankproject.Services;

public class UserRequest {

    private String userName;

    public UserRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
