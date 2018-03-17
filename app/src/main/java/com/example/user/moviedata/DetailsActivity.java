package com.example.user.moviedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 2018-03-17.
 */

public class DetailsActivity extends AppCompatActivity {

    ImageView movieBackdrop;
    ImageView moviePoster;

    TextView movieTitle, movieAverage, movieCount;
    TextView movieOriginal, movieRuntime, movieGenres, movieOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        movieBackdrop = (ImageView)findViewById(R.id.movie_backdrop);
        moviePoster = (ImageView)findViewById(R.id.movie_details_poster);

        movieTitle = (TextView)findViewById(R.id.movie_details_title);
        movieAverage = (TextView)findViewById(R.id.movie_details_average);
        movieCount = (TextView)findViewById(R.id.movie_count);

        movieOriginal = (TextView)findViewById(R.id.movie_original_title);
        movieRuntime = (TextView)findViewById(R.id.movie_runtime);
        movieGenres = (TextView)findViewById(R.id.movie_genres);
        movieOverview = (TextView)findViewById(R.id.movie_overview);

    }
}
