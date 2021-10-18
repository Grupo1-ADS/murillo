package com.example.starwarsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Specie {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("classification")
    @Expose
    private String classification;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("average_height")
    @Expose
    private String averageHeight;
    @SerializedName("skin_colors")
    @Expose
    private String skinColors;
    @SerializedName("hair_colors")
    @Expose
    private String hairColors;
    @SerializedName("eye_colors")
    @Expose
    private String eyeColors;
    @SerializedName("average_lifespan")
    @Expose
    private String averageLifespan;
    @SerializedName("homeworld")
    @Expose
    private String homeworld;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("people")
    @Expose
    private List<String> people = null;
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

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getPeople() {
        return people;
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
