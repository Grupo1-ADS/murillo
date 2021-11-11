package com.example.starwarsapp.networks;

import com.example.starwarsapp.models.specie.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpecieInterface {

    @GET("species")
    Call<SpecieResult> getSpecies(
        @Query("page") int page
    );

    @GET("species/{id}")
    Call<Specie> getSpecieById(
        @Path("id") int id
    );

    @GET("species")
    Call<SpecieResult> getSpeciesByName(
        @Query("search") String name,
        @Query("page") int page
    );

}
