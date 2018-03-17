package com.example.user.moviedata.model;

import com.example.user.moviedata.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by USER on 2018-03-17.
 * 영화의 상세정보
 */

public class Details {
    /*
        제목, 런타임, 원제, 요약 줄거리, 이미지 URL,
        개봉날짜, 평균점수, 투표인원
     */
    @SerializedName("title")
    private String movieTitle;
    @SerializedName("runtime")
    private Integer runTime;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overView;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("vote_count")
    private Integer rateCount;
    @SerializedName("vote_average")
    private Double rateAverage;
    @SerializedName("genres")
    private ArrayList<Genre> movieGenres;

    public Details(String movieTitle, Integer runTime, String originalTitle, String overView, String posterPath, String backdropPath, String releaseDate, Integer rateCount, Double rateAverage, ArrayList<Genre> movieGenres) {
        this.movieTitle = movieTitle;
        this.runTime = runTime;
        this.originalTitle = originalTitle;
        this.overView = overView;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.rateCount = rateCount;
        this.rateAverage = rateAverage;
        this.movieGenres = movieGenres;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverView() {
        return overView;
    }

    /*
        이미지 파일명만 받아오기 때문에 BASE URL 주소 추가
     */
    public String getPosterPath() {
        return Constants.baseImgURL + posterPath;
    }

    public String getBackdropPath() {
        if(backdropPath == null) {
            return null;
        }
        return Constants.baseImgURL + backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Integer getRateCount() {
        return rateCount;
    }

    public Double getRateAverage() {
        return rateAverage;
    }

    public ArrayList<Genre> getMovieGenres() {
        return movieGenres;
    }

    public class Genre {
        @SerializedName("name")
        private String genre_name;

        public Genre(String genre_name) {
            this.genre_name = genre_name;
        }

        public String getGenre_name() {
            return genre_name;
        }
    }
}
