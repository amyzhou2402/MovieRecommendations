package com.example.movierecommendations;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements Filterable {
    private ArrayList<Movie> mMovies;
    private ArrayList<Movie> mMoviesFiltered;

    public MovieAdapter(ArrayList<Movie> movies) {
        mMovies = movies;
        mMoviesFiltered = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        final Movie moviePosition = mMoviesFiltered.get(position);
        holder.name.setText(moviePosition.getName());

        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = view.getContext();
                Intent intent =  new Intent(context, MovieDetail.class);
                intent.putExtra("MovieID", moviePosition.getId());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    mMoviesFiltered = mMovies;
                } else {
                    ArrayList<Movie> filteredList = new ArrayList<>();
                    for(Movie movie : mMovies) {
                        if(movie.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(movie);
                        }
                    }
                    mMoviesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mMoviesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mMoviesFiltered = (ArrayList<Movie>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return mMoviesFiltered.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;

        public MovieViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.tvMovieNameBig);

        }
    }
}