package com.example.starwarsapp.networks;

import com.example.starwarsapp.models.vehicle.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VehicleInterface {

    @GET("vehicles")
    Call<VehicleResult> getVehicle(
        @Query("page") int page
    );

    @GET("vehicles/{id}")
    Call<Vehicle> getVehicleById(
        @Path("id") int id
    );

    @GET("vehicles")
    Call<VehicleResult> getVehicleByNameOrModel(
        @Query("search") String nameOrModel,
        @Query("page") int page
    );

}
