package com.example.arun.popularmovies1.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arun on 19/12/15.
 */
public class Movie implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("poster_path")
    private String imagePath;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String description;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private float rating;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("backdrop_path")
    private String backImage;

    @Override
    public int describeContents() {
        return 0;
    }

    public Movie(int id){
        this.id=id;
    }

    public Movie(Parcel in){
        id=in.readInt();
        imagePath = in.readString();
        title = in.readString();
        description = in.readString();
        releaseDate = in.readString();
        rating = in.readFloat();
        voteCount =in.readInt();
        popularity = in.readFloat();
        backImage=in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(imagePath);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(releaseDate);
        dest.writeFloat(rating);
        dest.writeInt(voteCount);
        dest.writeFloat(popularity);
        dest.writeString(backImage);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getBackImage() {
        return backImage;
    }
}
