package com.example.firebase_rest_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Movie>> call = apiService.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                Log.d("George","URL successfully responded");
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("George","NO Response. Reason: "+t.toString());
            }
        });

        com.example.firebase_rest_hw.Movie m1 = new com.example.firebase_rest_hw.Movie("title", "image");
        Call<ResponseBody> call2 = apiService.putMovie("id", m1);
        call2.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call2, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call2, Throwable t) {

            }
        });

        Call<ResponseBody> call3 = apiService.updateMovie("id", m1);
        call3.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call3, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call3, Throwable t) {

            }
        });
    }
}