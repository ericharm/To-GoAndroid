package com.ericharm.to_goandroid;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {
    @POST("login")
    Call<User> login(@Body LoginAttempt attempt);
}
