package com.primapp.movieapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

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

        String[] peliEjemplo = {
                "id1 - Nombre pelicula1",
                "id2 - Nombre pelicula2",
                "id3 - Nombre pelicula3"

        };

        lvMovie = (ListView)vRoot.findViewById(R.id.lvMain);

        adapterMovie = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_moviemain,
                R.id.movieTextView,
                listMovie
        );

        ListView lvMovie = (ListView) vRoot.findViewById(R.id.lvMovieMain);
        lvMovie.setAdapter(adapterMovie);

        return vRoot;
    }





}
