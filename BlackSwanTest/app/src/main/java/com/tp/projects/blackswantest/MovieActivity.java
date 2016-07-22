package com.tp.projects.blackswantest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tp.projects.blackswantest.util.JSONParser;
import com.tp.projects.blackswantest.util.MovieDBResponseHandler;
import com.tp.projects.blackswantest.util.NetworkHandler;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    Context ctx;
    private List<MovieTile> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = this;
        movieDataResponseHandler = cretateMovieDBResponseHandler();
        NetworkHandler.downloadMovieData(ctx, movieDataResponseHandler);

        /*JsonParser parser = new JsonParser();
        parseMovieJSONData(parser.parse(JSONParser.readStream("moviesArray.txt",ctx)).getAsJsonObject());
        initializeTileLayout();*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    MovieDBResponseHandler movieDataResponseHandler;

    private MovieDBResponseHandler cretateMovieDBResponseHandler() {
        return new MovieDBResponseHandler(ctx) {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                super.onCompleted(e, result);
                if (e == null) {
                    parseMovieJSONData(result);
                    initializeTileLayout();
                }
            }
        };

    }


    private void parseMovieJSONData(JsonObject result) {
        list = new ArrayList<>();
        JsonArray jsonList = result.getAsJsonArray("results");
        for (JsonElement movieJSON : jsonList) {
            MovieTile movie = (MovieTile) JSONParser.returnParsedClass(movieJSON, MovieTile.class);
            movie.setImageURLs();
            list.add(movie);
        }
    }

    private void initializeTileLayout() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_tiles_container);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new MovieTilesAdapter(ctx, list));
        }
    }


    private void initializeTileLayoutOffline() {
        List<MovieTile> list = new ArrayList<MovieTile>();
        MovieTile movie;
        String data = JSONParser.readStream("sampleMovieJSON.txt", ctx);
        movie = (MovieTile) JSONParser.returnParsedClass(data, MovieTile.class);
        list.add(movie);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_tiles_container);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new MovieTilesAdapter(ctx, list));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}