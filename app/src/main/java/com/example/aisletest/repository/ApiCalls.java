package com.example.aisletest.repository;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiCalls {

    @Headers({"Content-Type: application/json"})
    @POST("users/phone_number_login")
    Call<PhoneVerificationResponse> login_using_phone(@Body RequestBody requestBody, @Header("Cookie") String sessionIdAndToken);


    @Headers({"Content-Type: application/json"})
    @POST("users/verify_otp")
    Call<OtpVerificationResponse> verifyOtp(@Body RequestBody requestBody, @Header("Cookie") String sessionIdAndToken);

//__cfduid=df9b865983bd04a5de2cf5017994bbbc71618565720



}