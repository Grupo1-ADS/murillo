package com.example.starwarsapp.models.starship;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Starship implements Parcelable {

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
    @SerializedName("hyperdrive_rating")
    @Expose
    private String hyperdriveRating;
    @SerializedName("MGLT")
    @Expose
    private String mglt;
    @SerializedName("starship_class")
    @Expose
    private String starshipClass;
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

    protected Starship(Parcel in) {
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
        hyperdriveRating = in.readString();
        mglt = in.readString();
        starshipClass = in.readString();
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(model);
        parcel.writeString(manufacturer);
        parcel.writeString(costInCredits);
        parcel.writeString(length);
        parcel.writeString(maxAtmospheringSpeed);
        parcel.writeString(crew);
        parcel.writeString(passengers);
        parcel.writeString(cargoCapacity);
        parcel.writeString(consumables);
        parcel.writeString(hyperdriveRating);
        parcel.writeString(mglt);
        parcel.writeString(starshipClass);
        parcel.writeList(pilots);
        parcel.writeList(films);
        parcel.writeString(created);
        parcel.writeString(edited);
        parcel.writeString(url);
    }

    public static final Creator<Starship> CREATOR = new Creator<Starship>() {
        @Override
        public Starship createFromParcel(Parcel in) {
            return new Starship(in);
        }

        @Override
        public Starship[] newArray(int size) {
            return new Starship[size];
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

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public String getMGLT() {
        return mglt;
    }

    public String getStarshipClass() {
        return starshipClass;
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
