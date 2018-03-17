package com.example.user.moviedata.apis;

import com.example.user.moviedata.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by USER on 2018-03-17.
 */

public interface RetrofitService {

    // 현재 상영작 리스트 요청
    @GET("movie/now_playing")
    Call<Movie> getNowPlayingMovies(@Query("api_key") String apiKey, @Query("region") String region, @Query("language") String language);    // &파라메터=값의 형식으로 넘길땐 @Query 사용

    // 영화 상세정보 요청
    @GET("movie/{movie_id}")
    Call getMovieDetails(@Path("movie_id") Integer id, @Query("api_key") String apiKey, @Query("language") String language);
}
