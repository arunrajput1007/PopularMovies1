package com.example.arun.popularmovies1.service;

import com.example.arun.popularmovies1.models.MovieSet;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by arun on 19/12/15.
 */
public interface IMovieService {
    @GET("/3/movie/{categories}")
    Call<MovieSet> getMostPopularMovies(@Path("categories") String categories, @Query("api_key") String apiKey);
}
