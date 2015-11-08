package com.primapp.movieapp;

import android.graphics.Movie;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.primapp.movieapp.json.ApiData;
import com.primapp.movieapp.service.MovieService;

import java.util.ArrayList;
import java.util.Arrays;
import retrofit.GsonConverterFactory;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActFragment extends Fragment {


    private ArrayList<String> listMovie;
    private ArrayAdapter<String> adapterMovie;
    private ListView lvMovie;

    private View vRoot;
    Boolean menu = true;



    public MainActFragment() {
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(menu);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vRoot = inflater.inflate(R.layout.fragment_main, container, false);

        String[] peliEjemplo = {                    //creamos un ejemplo de lo que enlistaremos
                "id1 - Nombre pelicula1 - Año 1",
                "id2 - Nombre pelicula2 - Año 2",
                "id3 - Nombre pelicula3 - Año 3"
        };

        lvMovie = (ListView)vRoot.findViewById(R.id.lvFragment_Main); //referenciamos el listview del fragment_main
        listMovie = new ArrayList<>(Arrays.asList(peliEjemplo));
        adapterMovie = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_moviemain,
                R.id.tvMovie,
                listMovie
        );
        lvMovie.setAdapter(adapterMovie);

        return vRoot;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_movie_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    private void refresh(){
        String apiKey = "e6f2c549601727fca2e90f4291bbe34d";
        String sesionId = "47767573t";
        String urlBase = "https://api.themoviedb.org/3/";
        String mode = "";


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iMovieService service = retrofit.create(iMovieService.class);

        Call<ApiData> movieCall = service.getFavoriteMovies(sesionId);
        movieCall.enqueue(new Callback<ApiData>(){
            @Override
            public void onResponse(Response<ApiData> response, Retrofit retrofit) {
                if (response.isSuccess()) Log.d(null, "OK");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w(null, Arrays.toString(t.getStackTrace()));
            }
        });
    }


    public interface iMovieService {

        @GET ("favorites/movies")
        Call<ApiData> getFavoriteMovies(@Query("id") String Sesion);

        @GET ("rated/movies")
        Call<ApiData> getRatedMovies(@Query("id") String Sesion);




    }
}
