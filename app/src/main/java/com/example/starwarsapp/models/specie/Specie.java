package com.example.starwarsapp.models.specie;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Specie implements Parcelable {

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
    private List<String> people = new ArrayList<String>();
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

    protected Specie(Parcel in) {
        name = in.readString();
        classification = in.readString();
        designation = in.readString();
        averageHeight = in.readString();
        skinColors = in.readString();
        hairColors = in.readString();
        eyeColors = in.readString();
        averageLifespan = in.readString();
        homeworld = in.readString();
        language = in.readString();
        in.readList(this.people, (java.lang.String.class.getClassLoader()));
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
        parcel.writeString(classification);
        parcel.writeString(designation);
        parcel.writeString(averageHeight);
        parcel.writeString(skinColors);
        parcel.writeString(hairColors);
        parcel.writeString(eyeColors);
        parcel.writeString(averageLifespan);
        parcel.writeString(homeworld);
        parcel.writeString(language);
        parcel.writeList(people);
        parcel.writeList(films);
        parcel.writeString(created);
        parcel.writeString(edited);
        parcel.writeString(url);
    }

    public static final Creator<Specie> CREATOR = new Creator<Specie>() {
        @Override
        public Specie createFromParcel(Parcel in) {
            return new Specie(in);
        }

        @Override
        public Specie[] newArray(int size) {
            return new Specie[size];
        }
    };

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
