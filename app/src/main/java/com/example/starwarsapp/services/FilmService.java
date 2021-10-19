package com.example.starwarsapp.services;

import com.example.starwarsapp.models.Film;
import com.example.starwarsapp.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmService {

    @GET("films")
    Call<Result> getFilms(@Query("search") String title, @Query("page") int pageIndex);

    @GET("films")
    Call<Result> getFilmsByTitle(@Query("search") String title);

    @GET("films/{id}")
    Call<Film> getFilmById(@Path("id") int id);

}
