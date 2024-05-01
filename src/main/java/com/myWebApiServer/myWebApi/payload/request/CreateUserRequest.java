package com.myWebApiServer.myWebApi.payload.request;

import com.myWebApiServer.myWebApi.entity.Role;

import java.util.Set;

public class CreateUserRequest {
    private String name;
    private String surname;
    private String username;
    private String password;

    public CreateUserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
