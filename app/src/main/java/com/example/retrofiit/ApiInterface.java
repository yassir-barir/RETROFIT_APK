package com.example.retrofiit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts")
    public Call<List<POST>> getPost(@Query("userId") String userId);
}
