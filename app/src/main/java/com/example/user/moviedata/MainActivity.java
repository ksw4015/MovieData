package com.example.user.moviedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.moviedata.apis.Client;
import com.example.user.moviedata.apis.RetrofitService;
import com.example.user.moviedata.model.Movie;
import com.example.user.moviedata.model.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getMovieData() {

        try {

            Client client = new Client();
            RetrofitService service = Client.getClient().create(RetrofitService.class);

            Call<MovieResponse> movieCall = service.getNowPlayingMovies(Constants.API_KEY, Constants.MY_REGION, Constants.MY_LANGUAGE);
            movieCall.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                    ArrayList<Movie> movieList = response.body().getResults();



                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {

                }
            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
