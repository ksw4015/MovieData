package com.example.user.moviedata.model;

import com.example.user.moviedata.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 2018-03-17.
 * 현재 상영작 목록의 간략한 정보
 */

public class Movie {

    @SerializedName("title")
    private String moiveTitle;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("vote_average")
    private Double rateAverage;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("id")
    private Integer movieId;

    public Movie(String moiveTitle, String posterPath, Double rateAverage, String releaseDate, Integer movieId) {
        this.moiveTitle = moiveTitle;
        this.posterPath = posterPath;
        this.rateAverage = rateAverage;
        this.releaseDate = releaseDate;
        this.movieId = movieId;
    }

    public String getMoiveTitle() {
        return moiveTitle;
    }

    public String getPosterPath() {
        return Constants.baseImgURL + posterPath;
    }

    public Double getRateAverage() {
        return rateAverage;
    }

    public String getReleaseDate() {

        String date[] = releaseDate.split("-");
        String month = convertDate(date[1]);
        String day = convertDate(date[2]);

        return month + "월 " + day + "일";
    }

    private String convertDate(String date) {

        StringBuilder builder = new StringBuilder(date);

        if(builder.charAt(0) == '0') {
            builder.delete(0, 1);
        }

        return builder.toString();
    }

    public Integer getMovieId() {
        return movieId;
    }
}
