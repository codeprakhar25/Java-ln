package com.example.first.demo.utils;

public class LoginReponse {

    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
  
      }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

}
