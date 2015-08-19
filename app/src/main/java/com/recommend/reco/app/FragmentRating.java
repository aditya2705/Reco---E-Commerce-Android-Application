package com.recommend.reco.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sumeet on 26-06-2014.
 */
public class FragmentRating extends Fragment {

    public FragmentRating() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("CHECK", "fragment");

        View view = inflater.inflate(R.layout.fragment_rating, container,
                false);

        return view;
    }
}