package com.example.user.moviedata.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by USER on 2018-03-17.
 */

public class MovieResponse {

    @SerializedName("results")
    private ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }
}
