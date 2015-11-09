package com.primapp.movieapp.service;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.primapp.movieapp.json.ApiData;
import com.primapp.movieapp.json.Movie;

import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by 47767573t on 04/11/15.
 */
public class MovieApiRetrofit {
        String apiKey = "e6f2c549601727fca2e90f4291bbe34d";
        String sesionId = "47767573t";
        String urlBase = "https://api.themoviedb.org/3/";
        String mode = "";

        public MovieApiRetrofit() {
            super();
        }

    public void getFavoritesMovies(final ArrayAdapter adapter){

        final String urlEnd = "favorite/movie";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iMovieService servicio = retrofit.create(iMovieService.class);

        Call<ApiData> movieCall = servicio.getFavoriteMovies(apiKey);
        movieCall.enqueue(new Callback<ApiData>(){
            @Override
            public void onResponse(Response<ApiData> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    Log.d(null, "OK");
                    ApiData apiData = response.body();
                    adapter.clear();
                    /*for (Movie peli: apiData.getMovies()){
                        adapter.add(peli.getTitulo());
                    }*/


                } else { Log.d("RESPUESTA", response.errorBody().toString());}
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w(null, Arrays.toString(t.getStackTrace()));
            }
        });
    }


    interface iMovieService {
        @GET("movie/popular")
        Call<ApiData> getFavoriteMovies(
                @Query("apikey") String apiKey
        );

        @GET ("movie/top_rated")
        Call<ApiData> getRatedMovies(
                @Query("apikey") String apiKey
        );
    }





}
