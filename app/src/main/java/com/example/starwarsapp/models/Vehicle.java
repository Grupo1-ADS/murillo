package com.example.starwarsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vehicle {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("cost_in_credits")
    @Expose
    private String costInCredits;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("max_atmosphering_speed")
    @Expose
    private String maxAtmospheringSpeed;
    @SerializedName("crew")
    @Expose
    private String crew;
    @SerializedName("passengers")
    @Expose
    private String passengers;
    @SerializedName("cargo_capacity")
    @Expose
    private String cargoCapacity;
    @SerializedName("consumables")
    @Expose
    private String consumables;
    @SerializedName("vehicle_class")
    @Expose
    private String vehicleClass;
    @SerializedName("pilots")
    @Expose
    private List<String> pilots = null;
    @SerializedName("films")
    @Expose
    private List<String> films = null;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public String getLength() {
        return length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }

}
