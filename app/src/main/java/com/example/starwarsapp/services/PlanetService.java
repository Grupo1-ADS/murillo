package com.example.starwarsapp.services;

import com.example.starwarsapp.models.Planet;
import com.example.starwarsapp.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlanetService {

    @GET("planets")
    Call<Result> getPlanet(@Query("page") int pageIndex);

    @GET("planets")
    Call<Result> getPlanetByName(@Query("search") String name);

    @GET("planet/{id}")
    Call<Planet> getPlanetById(@Path("id") int id);

}