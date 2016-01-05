package com.example.arun.popularmovies1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.arun.popularmovies1.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by arun on 14/12/15.
 */
public class GridAdapter extends BaseAdapter {

    private final String imageBaseURL="http://image.tmdb.org/t/p/w185";
    private Context mContext=null;
    private ArrayList<String> moviePosterList=new ArrayList<String>();
    private ArrayList<Movie> movieList=new ArrayList<Movie>();

    public GridAdapter(Context context){
        mContext=context;
    }

    public void updateData(ArrayList<Movie> movieList){
        processImages(movieList);
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;
        if(convertView == null){
            imageView = new ImageView(mContext);
        } else {
            imageView = (ImageView) convertView;
        }
        if(moviePosterList.size()!=0) {
            Picasso.with(mContext).load(moviePosterList.get(position)).into(imageView);
            imageView.setAdjustViewBounds(true);
        }
        return imageView;
    }

    @Override
    public int getCount() {
        return moviePosterList.size();
    }

    public void processImages(ArrayList<Movie> movieList){

        if(this.movieList.size()!=0)
            this.movieList.clear();
        this.movieList=movieList;

        if(moviePosterList.size()!=0)
            moviePosterList.clear();

        ListIterator<Movie> movieListIterator=movieList.listIterator();
        while(movieListIterator.hasNext()){
            moviePosterList.add(imageBaseURL+movieListIterator.next().getImagePath());
        }
    }
}
