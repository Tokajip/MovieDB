package com.tp.projects.moviedb.movies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tp.projects.moviedb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tokaji Peter on 21/07/16.
 */
public class MovieTilesAdapter extends RecyclerView.Adapter<MovieTilesAdapter.Viewholder> {

    public static class Viewholder extends RecyclerView.ViewHolder {

        View tile;

        public Viewholder(View itemView) {
            super(itemView);
            tile = itemView;
        }
    }

    Context ctx;
    List<MovieData> movieList;

    public MovieTilesAdapter(Context context, List<MovieData> movieDatas) {
        ctx = context;
        movieList = new ArrayList<>();
        movieList.addAll(movieDatas);
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tile = LayoutInflater.from(ctx).inflate(R.layout.tile_layout, parent, false);

        return new Viewholder(tile);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        ((TextView) holder.tile.findViewById(R.id.tile_title)).setText(movieList.get(position).getTitle());
        ((TextView) holder.tile.findViewById(R.id.tile_popularity)).setText(String.valueOf(movieList.get(position).getVoteAverage()));
        ((TextView) holder.tile.findViewById(R.id.tile_description)).setText(movieList.get(position).getOverview());
        holder.tile.findViewById(R.id.more_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, MovieDetailsActivity.class);
                intent.putExtra("movie", movieList.get(position));
                ctx.startActivity(intent);
            }
        });

        Picasso.with(ctx)
                .load(movieList.get(position).getPosterPath())
                .placeholder(R.mipmap.ic_launcher)
                .into((ImageView) holder.tile.findViewById(R.id.tile_image));

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}