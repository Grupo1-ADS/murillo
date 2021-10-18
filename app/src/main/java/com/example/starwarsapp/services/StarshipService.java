package com.example.starwarsapp.services;

import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.models.Starship;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarshipService {

    @GET("starships")
    Call<Result> getStarship(@Query("page") int pageIndex);

    @GET("starships")
    Call<Result> getStarshipByNameOrModel(@Query("search") String nameOrModel);

    @GET("starships/{id}")
    Call<Starship> getStarshipById(@Path("id") int id);

}
