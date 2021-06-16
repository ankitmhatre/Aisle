package com.example.aisletest.repository;

import com.google.gson.annotations.SerializedName;

public class PhoneVerificationResponse {

    @SerializedName("status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
