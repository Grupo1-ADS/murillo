package com.example.starwarsapp.networks;

import com.example.starwarsapp.models.planet.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlanetInterface {

    @GET("planets")
    Call<PlanetResult> getPlanets(
        @Query("page") int page
    );

    @GET("planet/{id}")
    Call<Planet> getPlanetById(
        @Path("id") int id
    );

    @GET("planets")
    Call<PlanetResult> getPlanetsByName(
        @Query("search") String name,
        @Query("page") int page
    );

}
