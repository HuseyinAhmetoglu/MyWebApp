package com.myWebApiServer.myWebApi.dto;

public class JwtResponse {
    private String accessToken;

    public JwtResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
