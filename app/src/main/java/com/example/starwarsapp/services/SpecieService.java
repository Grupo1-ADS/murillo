package com.example.starwarsapp.services;

import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.models.Specie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpecieService {

    @GET("species")
    Call<Result> getSpecies(@Query("search") String name, @Query("page") int pageIndex);

    @GET("species")
    Call<Result> getSpeciesByName(@Query("search") String name);

    @GET("species/{id}")
    Call<Specie> getSpecieById(@Path("id") int id);

}
