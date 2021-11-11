package com.example.starwarsapp.networks;

import com.example.starwarsapp.models.people.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeopleInterface {

    @GET("people")
    Call<PeopleResult> getPeople(
        @Query("page") int page
    );

    @GET("people/{id}")
    Call<People> getPeopleById(
        @Path("id") int id
    );

    @GET("people")
    Call<PeopleResult> getPeopleByName(
        @Query("search") String name,
        @Query("page") int page
    );

}