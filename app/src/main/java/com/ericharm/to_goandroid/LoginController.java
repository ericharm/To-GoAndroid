package com.ericharm.to_goandroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginController implements Callback<User> {
    private String email, password;
    static final String BASE_URL = "http://10.0.2.2:8888/";

    public void start() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = RetrofitClient.getClient(BASE_URL);
        LoginApi api = retrofit.create(LoginApi.class);

        Call<User> call = api.login(new LoginAttempt(this.email, this.password));
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        if(response.isSuccessful()) {
            final User user = response.body();
            System.out.println("AUTH TOKEN : ");
            System.out.println(user.getAuthToken());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        t.printStackTrace();
    }

    public void setCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
