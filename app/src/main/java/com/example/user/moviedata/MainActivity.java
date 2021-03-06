package com.example.user.moviedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.user.moviedata.adapter.MovieAdapter;
import com.example.user.moviedata.apis.Client;
import com.example.user.moviedata.apis.RetrofitService;
import com.example.user.moviedata.model.Movie;
import com.example.user.moviedata.model.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView playingMovieListView;
    int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playingMovieListView = (RecyclerView)findViewById(R.id.playing_movie_list);
        if(playingMovieListView != null) {
            getMovieData();
        }

    }

    // 현재 상영작을 Api 요청을 통해 받아오고 리사이클러 뷰를 통해 보여준다
    private void getMovieData() {

        try {

            Client client = new Client();
            RetrofitService service = client.getClient().create(RetrofitService.class);

            Call<MovieResponse> movieCall = service.getNowPlayingMovies(Constants.API_KEY, Constants.MY_REGION, Constants.MY_LANGUAGE);
            movieCall.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                    if(response.body() != null) {
                        ArrayList<Movie> movieList = response.body().getResults();

                        MovieAdapter mAdapter = new MovieAdapter(MainActivity.this, movieList);
                        playingMovieListView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        playingMovieListView.setHasFixedSize(true);
                        playingMovieListView.setAdapter(mAdapter);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "정보를 가져오지 못했습니다. \nAPI키를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "데이터를 가져오지 못했습니다.", Toast.LENGTH_SHORT).show();
                }
            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
