package com.example.starwarsapp.models.people;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class People implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("mass")
    @Expose
    private String mass;
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    @SerializedName("skin_color")
    @Expose
    private String skinColor;
    @SerializedName("eye_color")
    @Expose
    private String eyeColor;
    @SerializedName("birth_year")
    @Expose
    private String birthYear;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("homeworld")
    @Expose
    private String homeworld;
    @SerializedName("films")
    @Expose
    private List<String> films = new ArrayList<String>();
    @SerializedName("species")
    @Expose
    private List<String> species = new ArrayList<String>();
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = new ArrayList<String>();
    @SerializedName("starships")
    @Expose
    private List<String> starships = new ArrayList<String>();
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    protected People(Parcel in) {
        name = in.readString();
        height = in.readString();
        mass = in.readString();
        hairColor = in.readString();
        skinColor = in.readString();
        eyeColor = in.readString();
        birthYear = in.readString();
        gender = in.readString();
        homeworld = in.readString();
        in.readList(this.films, (java.lang.String.class.getClassLoader()));
        in.readList(this.species, (java.lang.String.class.getClassLoader()));
        in.readList(this.vehicles, (java.lang.String.class.getClassLoader()));
        in.readList(this.starships, (java.lang.String.class.getClassLoader()));
        created = in.readString();
        edited = in.readString();
        url = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(height);
        parcel.writeString(mass);
        parcel.writeString(hairColor);
        parcel.writeString(skinColor);
        parcel.writeString(eyeColor);
        parcel.writeString(birthYear);
        parcel.writeString(gender);
        parcel.writeString(homeworld);
        parcel.writeList(films);
        parcel.writeList(species);
        parcel.writeList(vehicles);
        parcel.writeList(starships);
        parcel.writeString(created);
        parcel.writeString(edited);
        parcel.writeString(url);
    }

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getStarships() {
        return starships;
    }

    public List<String> getVehicles() {
        return vehicles;
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