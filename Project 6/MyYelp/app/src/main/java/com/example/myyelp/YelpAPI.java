package com.example.myyelp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpAPI {
    @GET("businesses/search")
    Call<ObjectsReturn> getObjects(@Query("term") String name, @Query("location") String location);
}
