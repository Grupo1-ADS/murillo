package com.example.starwarsapp.networks;

import com.example.starwarsapp.models.film.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmInterface {

    @GET("films")
    Call<FilmResult> getFilms(
        @Query("page") int page
    );

    @GET("films/{id}")
    Call<Film> getFilmById(
        @Path("id") int id
    );

    @GET("films")
    Call<FilmResult> getFilmsByTitle(
        @Query("search") String title,
        @Query("page") int page
    );

}
