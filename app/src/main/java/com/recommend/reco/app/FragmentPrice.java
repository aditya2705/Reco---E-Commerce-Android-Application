package com.recommend.reco.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sumeet on 23-06-2014.
 */
public class FragmentPrice extends Fragment{

    public FragmentPrice() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("CHECK", "fragment");

        View view = inflater.inflate(R.layout.fragment_movie_detail, container,
                false);

        return view;
    }
}