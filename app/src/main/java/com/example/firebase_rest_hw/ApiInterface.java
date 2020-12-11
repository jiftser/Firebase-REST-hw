package com.example.firebase_rest_hw;

import android.graphics.Movie;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("volley_array.json")
    Call<List<Movie>> getMovies();

    @PUT("volley_array/{id}")
    Call<ResponseBody> putMovie(@Path("id") String id, @Body com.example.firebase_rest_hw.Movie movie);

    @PATCH("volley_array/{id}")
    Call<ResponseBody> updateMovie(@Path("id") String id, @Body com.example.firebase_rest_hw.Movie movie);
}
