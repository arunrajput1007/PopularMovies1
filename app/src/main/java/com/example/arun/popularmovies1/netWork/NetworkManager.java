package com.example.arun.popularmovies1.netWork;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.arun.popularmovies1.adapter.GridAdapter;
import com.example.arun.popularmovies1.models.Movie;
import com.example.arun.popularmovies1.models.MovieSet;
import com.example.arun.popularmovies1.service.IMovieService;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by arun on 20/12/15.
 */
public class NetworkManager implements Callback<MovieSet> {
    private final String BASE_URL = "http://api.themoviedb.org/";
    private final String API_KEY= "api_key";
    private Retrofit retrofit=null;
    private IMovieService service=null;
    private ArrayList<Movie> movieList = new ArrayList<Movie>();
    private Context mContext=null;
    private GridAdapter gridAdapter=null;
    private ProgressDialog mProgressDialog=null;

    public NetworkManager(Context mContext,GridAdapter gridAdapter) {
        this.mContext=mContext;
        this.gridAdapter=gridAdapter;
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory
                        .create()).build();
        service = retrofit.create(IMovieService.class);
    }

    public void getMovies(String category) {
        mProgressDialog = new ProgressDialog(mContext,ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Please wait while we are loading movies ...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
        Call<MovieSet> movieCall = service.getMostPopularMovies(category, API_KEY);
        movieCall.enqueue(this);
    }

    @Override
    public void onResponse(Response<MovieSet> response, Retrofit retrofit) {
        if (response.isSuccess() && response.body().getMovieList().size() > 0) {
            if(movieList.size()!=0)
                movieList.clear();

            movieList = response.body().getMovieList();
            gridAdapter.updateData(movieList);
        }
        mProgressDialog.dismiss();
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
    }

}
