package com.example.user.moviedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.moviedata.apis.Client;
import com.example.user.moviedata.apis.RetrofitService;
import com.example.user.moviedata.model.Details;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USER on 2018-03-17.
 */

public class DetailsActivity extends AppCompatActivity {

    Integer movieId;

    ImageView movieBackdrop;
    ImageView moviePoster;

    TextView movieTitle, movieAverage, movieCount;
    TextView movieOriginal, movieRuntime, movieGenres, movieOverview, movieReleaseYear;

    ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        actionBar = getSupportActionBar();

        movieId = getIntent().getIntExtra(getResources().getString(R.string.movie_id), 0);

        movieBackdrop = (ImageView)findViewById(R.id.movie_backdrop);
        moviePoster = (ImageView)findViewById(R.id.movie_details_poster);

        movieTitle = (TextView)findViewById(R.id.movie_details_title);
        movieAverage = (TextView)findViewById(R.id.movie_details_average);
        movieCount = (TextView)findViewById(R.id.movie_count);

        movieOriginal = (TextView)findViewById(R.id.movie_original_title);
        movieRuntime = (TextView)findViewById(R.id.movie_runtime);
        movieGenres = (TextView)findViewById(R.id.movie_genres);
        movieOverview = (TextView)findViewById(R.id.movie_overview);
        movieReleaseYear = (TextView)findViewById(R.id.movie_release_year);

        if(movieId == 0) {
            Toast.makeText(DetailsActivity.this, "영화 정보를 받아오지 못했습니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            setMovieDetails();
        }
    }

    private void setMovieDetails() {

        try {

            Client client = new Client();
            RetrofitService service = client.getClient().create(RetrofitService.class);

            Call<Details> details = service.getMovieDetails(movieId, Constants.API_KEY, Constants.MY_LANGUAGE);
            details.enqueue(new Callback<Details>() {
                @Override
                public void onResponse(Call<Details> call, Response<Details> response) {
                    Details movieDetails = (Details)response.body();

                    //
                    String count = Integer.toString(movieDetails.getRateCount());
                    String average = Double.toString(movieDetails.getRateAverage());
                    String runtime = Integer.toString(movieDetails.getRunTime());

                    // 개봉년도
                    String year = movieDetails.getReleaseDate().substring(0, 4);

                    // 영화의 backdrop 이미지가 없는경우 기본 이미지 셋팅
                    if(movieDetails.getBackdropPath() == null) {
                        Glide.with(DetailsActivity.this)
                                .load(R.drawable.placeholder_image)
                                .into(movieBackdrop);
                    }
                    else {
                        Glide.with(DetailsActivity.this)
                                .load(movieDetails.getBackdropPath())
                                .into(movieBackdrop);
                    }

                    // 포스터 이미지
                    Glide.with(DetailsActivity.this)
                            .load(movieDetails.getPosterPath())
                            .into(moviePoster);

                    // 영화 제목
                    movieTitle.setText(movieDetails.getMovieTitle());
                    // 액션바 제목을 영화제목으로
                    actionBar.setTitle(movieDetails.getMovieTitle());
                    // 평균 별점
                    movieAverage.setText(new StringBuilder()
                            .append("평균 ")
                            .append(average)
                            .append("점")
                            .toString());
                    // 투표한 인원 수
                    movieCount.setText(new StringBuilder()
                            .append("(")
                            .append(count)
                            .append(" 명)")
                            .toString());

                    // 영화의 영어제목 (원제)
                    movieOriginal.setText(movieDetails.getOriginalTitle());
                    // 러닝타임
                    movieRuntime.setText(runtime + "분");
                    // 줄거리 요약
                    movieOverview.setText(movieDetails.getOverView());
                    // 개봉년도
                    movieReleaseYear.setText(year);

                    // 장르 장르1ㆍ장르2....
                    StringBuilder genreBuilder = new StringBuilder();
                    for(int i = 0 ; i < movieDetails.getMovieGenres().size() ; i++) {
                        if(i == movieDetails.getMovieGenres().size() - 1) {
                            genreBuilder.append(movieDetails.getMovieGenres().get(i).getGenre_name());
                        }
                        else {
                            genreBuilder
                                    .append(movieDetails.getMovieGenres().get(i).getGenre_name())
                                    .append("ㆍ");
                        }
                    }

                    movieGenres.setText(genreBuilder.toString());
                }

                @Override
                public void onFailure(Call<Details> call, Throwable t) {
                    Toast.makeText(DetailsActivity.this, "영화 정보를 받아오지 못했습니다.", Toast.LENGTH_SHORT).show();
                }
            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
