package com.example.starwarsapp.services;

import com.example.starwarsapp.models.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeopleService {

    @GET("people")
    Call<Result> getPeople(
        @Query("search") String name,
        @Query("page") int pageIndex
    );

    @GET("people")
    Call<Result> getPeopleByName(
        @Query("search") String name
    );

    @GET("people/{id}")
    Call<People> getPeopleById(@Path("id") int id);

}