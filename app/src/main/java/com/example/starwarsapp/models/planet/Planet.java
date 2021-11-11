package com.example.starwarsapp.models.planet;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Planet implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rotation_period")
    @Expose
    private String rotationPeriod;
    @SerializedName("orbital_period")
    @Expose
    private String orbitalPeriod;
    @SerializedName("diameter")
    @Expose
    private String diameter;
    @SerializedName("climate")
    @Expose
    private String climate;
    @SerializedName("gravity")
    @Expose
    private String gravity;
    @SerializedName("terrain")
    @Expose
    private String terrain;
    @SerializedName("surface_water")
    @Expose
    private String surfaceWater;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("residents")
    @Expose
    private List<String> residents = new ArrayList<String>();
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

    protected Planet(Parcel in) {
        name = in.readString();
        rotationPeriod = in.readString();
        orbitalPeriod = in.readString();
        diameter = in.readString();
        climate = in.readString();
        gravity = in.readString();
        terrain = in.readString();
        surfaceWater = in.readString();
        population = in.readString();
        in.readList(this.residents, (java.lang.String.class.getClassLoader()));
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(rotationPeriod);
        parcel.writeString(orbitalPeriod);
        parcel.writeString(diameter);
        parcel.writeString(climate);
        parcel.writeString(gravity);
        parcel.writeString(terrain);
        parcel.writeString(surfaceWater);
        parcel.writeString(population);
        parcel.writeList(residents);
        parcel.writeList(films);
        parcel.writeString(created);
        parcel.writeString(edited);
        parcel.writeString(url);
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getGravity() {
        return gravity;
    }

    public String getPopulation() {
        return population;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public List<String> getResidents() {
        return residents;
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
