package com.example.user.moviedata.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by USER on 2018-03-17.
 */

public class Client {

    // Api요청시 Base Url주소
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
