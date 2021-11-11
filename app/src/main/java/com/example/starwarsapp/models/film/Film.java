package com.example.starwarsapp.models.film;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Film implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("episode_id")
    @Expose
    private Integer episodeId;
    @SerializedName("opening_crawl")
    @Expose
    private String openingCrawl;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("characters")
    @Expose
    private List<String> characters = new ArrayList<String>();
    @SerializedName("planets")
    @Expose
    private List<String> planets = new ArrayList<String>();
    @SerializedName("starships")
    @Expose
    private List<String> starships = new ArrayList<String>();
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = new ArrayList<String>();
    @SerializedName("species")
    @Expose
    private List<String> species = new ArrayList<String>();
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    protected Film(Parcel in) {
        title = in.readString();
        episodeId = in.readInt();
        openingCrawl = in.readString();
        director = in.readString();
        producer = in.readString();
        releaseDate = in.readString();
        in.readList(this.characters, (java.lang.String.class.getClassLoader()));
        in.readList(this.planets, (java.lang.String.class.getClassLoader()));
        in.readList(this.starships, (java.lang.String.class.getClassLoader()));
        in.readList(this.vehicles, (java.lang.String.class.getClassLoader()));
        in.readList(this.species, (java.lang.String.class.getClassLoader()));
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
        parcel.writeString(title);
        parcel.writeInt(episodeId);
        parcel.writeString(openingCrawl);
        parcel.writeString(director);
        parcel.writeString(producer);
        parcel.writeString(releaseDate);
        parcel.writeList(characters);
        parcel.writeList(planets);
        parcel.writeList(starships);
        parcel.writeList(vehicles);
        parcel.writeList(species);
        parcel.writeString(created);
        parcel.writeString(edited);
        parcel.writeString(url);
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
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

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> getPlanets() {
        return planets;
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
