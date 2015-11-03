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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActFragment extends Fragment {


    private ArrayList<String> listMovie = new ArrayList<>();
    private ArrayAdapter adapterMovie;
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

        lvMovie = (ListView)vRoot.findViewById(R.id.lvMovieMain); //referenciamos el listview del fragment_main
        listMovie = new ArrayList(Arrays.asList(peliEjemplo));
        adapterMovie = new ArrayAdapter<String>(
                getContext(),
                R.layout.lv_moviemain,
                R.id.movieTextView,
                listMovie
        );

        lvMovie = (ListView) vRoot.findViewById(R.id.lvMovieMain);
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
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public void onStart() {
        super.onStart();
        refresh();
    }*/

    /*private void refresh(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/550?")
                .build();

        MovieService service = retrofit.create(MovieService.class);

        Call<Movie> movieCall = service.dailyMovie();
        movieCall.enqueue(new Callback<Movie>(){
            @Override
            public void onResponse(Response<Movie> response, Retrofit retrofit) {

            }


            @Override
            public void onFailure(Throwable t) {
                //Log.w(null, Arrays.toString(t.getStackTrace()));
            }
        });
    }*/


    /*public interface MovieService {


    }*/
}
