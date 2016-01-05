package com.example.arun.popularmovies1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.arun.popularmovies1.R;
import com.example.arun.popularmovies1.adapter.GridAdapter;
import com.example.arun.popularmovies1.models.Movie;
import com.example.arun.popularmovies1.netWork.NetworkManager;

public class MainActivity extends AppCompatActivity {

    private final String POPULAR_MOVIES="popular";
    private final String TOP_RATED_MOVIES="top_rated";
    private NetworkManager networkManager = null;
    private GridView gridView = null;
    private GridAdapter gridAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.grid_view);
        gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);
        networkManager = new NetworkManager(this, gridAdapter);
        networkManager.getMovies(POPULAR_MOVIES);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie=(Movie) parent.getAdapter().getItem(position);
                Intent intent= new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("movie",movie);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_pop_movies) {
            if(item.isChecked())
                item.setChecked(false);
            else{
                item.setChecked(true);
                networkManager.getMovies(POPULAR_MOVIES);}
        }
        if (id == R.id.menu_top_rated_movies) {
            if(item.isChecked())
                item.setChecked(false);
            else{
                item.setChecked(true);
                networkManager.getMovies(TOP_RATED_MOVIES);}
        }
        return true;
    }
}

