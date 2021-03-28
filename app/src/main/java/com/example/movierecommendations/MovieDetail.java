package com.example.movierecommendations;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.URL;

public class MovieDetail extends AppCompatActivity {

//    Button sessionTimes = findViewById(R.id.btSearchTrailer); // add the button id thing.

    private TextView movieName;
    private TextView movieNameBig;
    private TextView rating;
    private RatingBar ratingBar;
    private Button searchTrailer;
    private TextView genre;
    private TextView description;
    private TextView releaseYear;
    private ImageView image;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        // find the entire object using the unique id

        Intent intent = getIntent();
        final int movieId = intent.getIntExtra("MovieID", 0);
        final Movie movie = Movie.getMovie(movieId);

        // assigning variables
        movieName = findViewById(R.id.tvMovieName);
        movieNameBig = findViewById(R.id.tvMovieNameBig);
        rating = findViewById(R.id.tvRating);
        ratingBar = findViewById(R.id.ratingBar);
        genre = findViewById(R.id.tvGenre);
        description = findViewById(R.id.tvDescription);
        releaseYear = findViewById(R.id.tvReleaseYear);
        image = findViewById(R.id.ivImage);

        // Setting the text
        movieName.setText(movie.getName());
        movieNameBig.setText(movie.getName());
        rating.setText(String.valueOf(movie.getRating()));
        description.setText(movie.getDescription());
        releaseYear.setText(String.valueOf(movie.getReleaseYear()));
        ratingBar.setRating(movie.getRating());
        genre.setText(movie.getGenre());

        //method to have button link to movie trailer
        searchTrailer = findViewById(R.id.btSearchTrailer);
        searchTrailer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showVideo("https://www.youtube.com/results?search_query=movie+trailer+" + movie.getName());
            }
            private void showVideo(String url) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        // set image
        new DownloadImageTask((ImageView) findViewById(R.id.imageView)).execute(movie.getImageUrl());
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
