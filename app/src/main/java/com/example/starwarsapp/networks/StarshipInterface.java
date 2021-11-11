package com.example.starwarsapp.networks;

import com.example.starwarsapp.models.starship.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarshipInterface {

    @GET("starships")
    Call<StarshipResult> getStarship(
        @Query("page") int page
    );

    @GET("starships/{id}")
    Call<Starship> getStarshipById(
        @Path("id") int id
    );

    @GET("starships")
    Call<StarshipResult> getStarshipByNameOrModel(
        @Query("search") String nameOrModel,
        @Query("page") int page
    );

}
