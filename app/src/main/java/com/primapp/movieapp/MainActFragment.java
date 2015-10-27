package com.primapp.movieapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActFragment extends Fragment {


    private ArrayList<String> listMovie = new ArrayList<String>();
    private ArrayAdapter adapterMovie;

    private ListView lvMovie;

    private View vRoot;


    public MainActFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vRoot = inflater.inflate(R.layout.fragment_main, container, false);
        return vRoot;
    }





}
