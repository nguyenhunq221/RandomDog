package com.vnc.randomdog.api;

import com.vnc.randomdog.model.Dog;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    ApiService service = new Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("breeds/image/random")
    Call<Dog> getDogImage();
}
