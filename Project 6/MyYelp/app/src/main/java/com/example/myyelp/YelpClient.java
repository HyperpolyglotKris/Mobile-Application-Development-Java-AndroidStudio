package com.example.myyelp;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YelpClient {

    private static String API_KEY = "bGlRuqob5hWSkqzLsYXh7GaG5cfsmNqHEEbF-lItwszy3o7VOyVXX3nTE8ueeB-AN0WCGyBsmZHHmymWqRw8nybSkJt7y7EpddBq0u-A3IhFL7_t1kfO4aP2fIOuYnYx";

    public YelpAPI build() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        return chain.proceed(chain.request().newBuilder().addHeader("Authorization", "Bearer "+ API_KEY).build());
                    }
                }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.yelp.com/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(YelpAPI.class);
    }
}
