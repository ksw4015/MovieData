package com.example.user.moviedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 2018-03-17.
 */

public class Movie {

    // 포스터 및 백드롭 이미지 URL
    public static final String baseImgURL = "https://image.tmdb.org/t/p/w500";

    @SerializedName("title")
    private String moiveTitle;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("vote_average")
    private Double rateAverage;
    @SerializedName("release_date")
    private String releaseDate;

    public Movie(String moiveTitle, String posterPath, Double rateAverage, String releaseDate) {
        this.moiveTitle = moiveTitle;
        this.posterPath = posterPath;
        this.rateAverage = rateAverage;
        this.releaseDate = releaseDate;
    }

    public String getMoiveTitle() {
        return moiveTitle;
    }

    public String getPosterPath() {
        return baseImgURL + posterPath;
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

}
