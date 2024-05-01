package com.myWebApiServer.myWebApi.payload;

import com.myWebApiServer.myWebApi.entity.User;

public class UserVO {
    private String name;
    private String surname;
    private String username;

    public UserVO() {
    }

    public UserVO(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
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
}
