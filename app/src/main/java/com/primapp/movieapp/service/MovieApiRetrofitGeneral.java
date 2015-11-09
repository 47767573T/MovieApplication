package com.primapp.movieapp.service;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.primapp.movieapp.json.ApiData;
import com.primapp.movieapp.json.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
public class MovieApiRetrofitGeneral {
        String apiKey = "e6f2c549601727fca2e90f4291bbe34d";
        String sesionId = "47767573t";
        String urlBase = "https://api.themoviedb.org/3/";
        String mode = "account/";

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iMovieService service = retrofit.create(iMovieService.class);
*/
        public MovieApiRetrofitGeneral() {
            super();
        }

    public void getFavoritesMovies(final ArrayAdapter adapter) {
        final String postUrl = "favorites/movies.json";
        final String sesion_PARAM = "sesionId";
        final String apiKey_PARAM = "apiKey";

        Uri builtUri = Uri.parse(urlBase + mode + postUrl).buildUpon()
                .appendQueryParameter(sesion_PARAM, sesionId)
                .appendQueryParameter(apiKey_PARAM, apiKey)
                .build();
        Log.w(null, builtUri.toString());

        try {
            URL url = new URL(builtUri.toString());

            DownloadMoviesTask task = new DownloadMoviesTask();
            task.execute(adapter, url);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        public class DownloadMoviesTask extends AsyncTask<Object, Void, ArrayList<String>> {

            private ArrayAdapter<String> adapter;

            @Override
            protected ArrayList<String> doInBackground(Object... params) {
                adapter = (ArrayAdapter<String>) params[0];
                URL url = (URL) params[1];

                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                ArrayList<String> movieTitles = new ArrayList<>();
                try {
                    // Create the request to OpenWeatherMap, and open the connection
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    // Read the input stream into a String
                    InputStream inputStream = urlConnection.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    Gson gson = new Gson();
                    ApiData apiData = gson.fromJson(reader, ApiData.class);

                    List<Movie> movies = apiData.getMovies();

                    for (Movie movie : movies) {
                        movieTitles.add(movie.getTitle());
                    }

                } catch (IOException e) {
                    Log.e(null, "Error ", e);
                    // If the code didn't successfully get the weather data, there's no point in attempting
                    // to parse it.
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e(null, "Error closing stream", e);
                        }
                    }
                }
                return movieTitles;
            }
        }

        @Override
        protected void onProgressUpdate (Void...values){
             super.onProgressUpdate(values);
        }

         @Override
        protected void onPostExecute (ArrayList < String > movie) {
            super.onPostExecute(movie);
    
            adapter.clear();
            adapter.addAll(movie);
    
        }
    }
}
