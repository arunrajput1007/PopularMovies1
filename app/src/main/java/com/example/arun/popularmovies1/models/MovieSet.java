package com.example.arun.popularmovies1.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun on 19/12/15.
 */
public class MovieSet implements Parcelable {
    @SerializedName("page")
    private int currentPage;

    @SerializedName("results")
    private ArrayList<Movie> movieList;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    public MovieSet(int currentPage){
        this.currentPage=currentPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public MovieSet(Parcel in){
        currentPage = in.readInt();
        movieList = in.createTypedArrayList(Movie.CREATOR);
        totalResults = in.readInt();
        currentPage = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(currentPage);
        dest.writeTypedList(movieList);
        dest.writeInt(totalResults);
        dest.writeInt(totalPages);
    }

    public static Creator<MovieSet> CREATOR = new Creator<MovieSet>() {
        @Override
        public MovieSet createFromParcel(Parcel source) {
            return new MovieSet(source);
        }

        @Override
        public MovieSet[] newArray(int size) {
            return new MovieSet[size];
        }
    };

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
