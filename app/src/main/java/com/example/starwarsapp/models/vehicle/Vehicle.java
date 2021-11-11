package com.example.starwarsapp.models.vehicle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Parcelable {

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
    private List<String> pilots = new ArrayList<String>();
    @SerializedName("films")
    @Expose
    private List<String> films = new ArrayList<String>();
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    protected Vehicle(Parcel in) {
        name = in.readString();
        model = in.readString();
        manufacturer = in.readString();
        costInCredits = in.readString();
        length = in.readString();
        maxAtmospheringSpeed = in.readString();
        crew = in.readString();
        passengers = in.readString();
        cargoCapacity = in.readString();
        consumables = in.readString();
        vehicleClass = in.readString();
        in.readList(this.pilots, (java.lang.String.class.getClassLoader()));
        in.readList(this.films, (java.lang.String.class.getClassLoader()));
        created = in.readString();
        edited = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeString(manufacturer);
        dest.writeString(costInCredits);
        dest.writeString(length);
        dest.writeString(maxAtmospheringSpeed);
        dest.writeString(crew);
        dest.writeString(passengers);
        dest.writeString(cargoCapacity);
        dest.writeString(consumables);
        dest.writeString(vehicleClass);
        dest.writeList(pilots);
        dest.writeList(films);
        dest.writeString(created);
        dest.writeString(edited);
        dest.writeString(url);
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

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
