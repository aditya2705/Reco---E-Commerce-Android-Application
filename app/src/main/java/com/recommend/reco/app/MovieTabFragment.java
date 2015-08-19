package com.recommend.reco.app;

/**
 * Created by Sumeet on 27-06-2014.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

public class MovieTabFragment extends Fragment{

    private static final String tag = "Fragment: ";

    public static final String TAG = MovieTabFragment.class
            .getSimpleName();

    public static MovieTabFragment newInstance() {
        return new MovieTabFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_tabs, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view
                .findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        private final String[] TITLES = { "Trending", "Friends", "Global", "Critics"};

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            Log.v(tag, "" + position);
            switch (position) {
                case 0:
                    return MovieItemFragment.newInstance(0);
                case 1:
                    return MovieItemFragment.newInstance(1);
                case 2:
                    return MovieItemFragment.newInstance(2);
                case 3:
                    return MovieItemFragment.newInstance(3);
            }

            return null;
        }

    }


}
