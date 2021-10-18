package com.example.starwarsapp.services;

import com.example.starwarsapp.models.Result;
import com.example.starwarsapp.models.Vehicle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VehicleService {

    @GET("vehicles")
    Call<Result> getVehicle(@Query("page") int pageIndex);

    @GET("vehicles")
    Call<Result> getVehicleByNameOrModel(@Query("search") String nameOrModel);

    @GET("vehicles/{id}")
    Call<Vehicle> getVehicleById(@Path("id") int id);

}
