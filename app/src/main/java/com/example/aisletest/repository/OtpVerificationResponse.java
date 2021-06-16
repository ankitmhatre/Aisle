package com.example.aisletest.repository;

import com.google.gson.annotations.SerializedName;

public class OtpVerificationResponse {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
