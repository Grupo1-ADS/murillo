package com.example.starwarsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Film {

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
    private List<String> characters = null;
    @SerializedName("planets")
    @Expose
    private List<String> planets = null;
    @SerializedName("starships")
    @Expose
    private List<String> starships = null;
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = null;
    @SerializedName("species")
    @Expose
    private List<String> species = null;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

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
