package com.example.demo.models.view;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String token;

    private long expiresIn;

    public LoginResponse(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

}