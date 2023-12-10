package com.myWebApiServer.myWebApi.dto;

import com.myWebApiServer.myWebApi.model.Role;

import java.util.Set;

public class CreateUserRequest {
    private String name;
    private String surname;
    private String tcIdNumber;
    private String password;
    private Set<Role> authorities;

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

    public String getTcIdNumber() {
        return tcIdNumber;
    }

    public void setTcIdNumber(String tcIdNumber) {
        this.tcIdNumber = tcIdNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
