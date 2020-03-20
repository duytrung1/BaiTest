package com.example.baitest.Modeel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {
    @GET("employee")
    Call<Model>getPost();
}
