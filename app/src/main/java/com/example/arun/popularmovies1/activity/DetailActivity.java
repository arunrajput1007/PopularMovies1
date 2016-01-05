package com.example.arun.popularmovies1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arun.popularmovies1.R;
import com.example.arun.popularmovies1.models.Movie;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private final String IMAGE_BASE_URL_BACK="http://image.tmdb.org/t/p/w780";
    private final String IMAGE_BASE_URL_FRONT="http://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView backImage=(ImageView) findViewById(R.id.imageView);
        ImageView posterImage=(ImageView)findViewById(R.id.imageView2);
        Intent intent =getIntent();
        Movie movie=(Movie)intent.getParcelableExtra("movie");
        Picasso.with(this).load(IMAGE_BASE_URL_BACK+movie.getBackImage()).into(backImage);
        backImage.setAdjustViewBounds(true);
        Picasso.with(this).load(IMAGE_BASE_URL_FRONT+movie.getImagePath()).into(posterImage);
        backImage.setAdjustViewBounds(true);
        TextView title_view=(TextView) findViewById(R.id.title_tv);
        title_view.setText(movie.getTitle());
        TextView releaseDate=(TextView) findViewById(R.id.release_date_tv);
        releaseDate.setText("Release Date :"+movie.getReleaseDate());
        TextView rating = (TextView)findViewById(R.id.rating_tv);
        rating.setText("Ratings :"+movie.getRating());
        TextView synopsis = (TextView) findViewById(R.id.synopsis);
        synopsis.setText("Synopsis :"+movie.getDescription());
    }

}
