package com.example.user.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 2018-03-17.
 */

public class Details {

    @SerializedName("title")
    private String movieTitle;
    @SerializedName("runtime")
    private String runTime;
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

    public Details(String movieTitle, String runTime, String originalTitle, String overView, String posterPath, String backdropPath, String releaseDate, Integer rateCount, Double rateAverage) {
        this.movieTitle = movieTitle;
        this.runTime = runTime;
        this.originalTitle = originalTitle;
        this.overView = overView;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.rateCount = rateCount;
        this.rateAverage = rateAverage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverView() {
        return overView;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
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
}
