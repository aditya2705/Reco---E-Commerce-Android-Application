package com.recommend.reco.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class MovieItemFragment extends Fragment implements GridView.OnItemClickListener {

    ArrayList<MovieItem> gridArray = new ArrayList<MovieItem>();
    private MovieItemAdapter movieItemAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAB_NUMBER = "-1";

    // TODO: Rename and change types of parameters
    private int mTabnum;

    private OnFragmentInteractionListener mListener;



    /**
     * The fragment's ListView/GridView.
     */
    private GridView mListView;



    // TODO: Rename and change types of parameters
    public static MovieItemFragment newInstance(int param1) {
        MovieItemFragment fragment = new MovieItemFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_NUMBER, param1);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mTabnum = getArguments().getInt(TAB_NUMBER);
        }


        fillList();



        // TODO: Change Adapter to display your content
        movieItemAdapter = new MovieItemAdapter(getActivity(), R.layout.movie_item, gridArray);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movieitem, container, false);

        // Set the adapter
        mListView = (GridView) view.findViewById(R.id.grid_view);

        mListView.setAdapter(movieItemAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.

            /*
            //popup window code here
            Dialog alertbox = new Dialog(getActivity());

            alertbox.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertbox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(2, 0, 0, 0)));

            alertbox.setContentView(R.layout.movie_detail_dialog);

            ScrollView sv = (ScrollView) alertbox.findViewById(R.id.scroll_dialog);
            RelativeLayout r1 = (RelativeLayout) sv.findViewById(R.id.layout1);
            TextView t1 = (TextView) r1.findViewById(R.id.movie_description);

            t1.setText(getMovie(position));


            alertbox.show();

            */
            Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
            MovieItemFragment.this.startActivity(intent);
            mListener.onFragmentInteraction(null);
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("CHECK", "Menu fragment click"+ mTabnum);
        inflater.inflate(R.menu.filter_sort_menu,menu);

        super.onCreateOptionsMenu(menu, inflater);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter:
                return true;
            case R.id.sort:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void fillList() {


        switch(mTabnum){

        case 0: //Trending Tab
            //adding manually example
            gridArray.add(new MovieItem("Inception", "Suspense", R.drawable.ic_launcher, 5, 30));
            gridArray.add(new MovieItem("Inception", "Suspense", R.drawable.ic_launcher, 5, 30));
            gridArray.add(new MovieItem("Inception", "Suspense", R.drawable.ic_launcher, 5, 30));
            gridArray.add(new MovieItem("Inception", "Suspense", R.drawable.ic_launcher, 5, 30));
            break;

        case 1: //Friends Tab

            break;
        case 2: //Global Tab

            gridArray.add(new MovieItem("Shawshank", "Suspense", R.drawable.ic_launcher, 4.8, 40));
            gridArray.add(new MovieItem("Shawshank", "Suspense", R.drawable.ic_launcher, 4.7, 50));
            gridArray.add(new MovieItem("Shawshank", "Suspense", R.drawable.ic_launcher, 4.8, 40));
            gridArray.add(new MovieItem("Shawshank", "Suspense", R.drawable.ic_launcher, 4.7, 50));

            break;
        case 3: //Critics Tab

            break;

        }





    }


    private String getMovie(int position) {

        return "sfvjabvjar \nFJBjf \nsdvKRN s WR erb \nad v\n " +
                "\nER \nerb\n a \n\ndv\n adb RB\n erb s V SDC  wg WG  " +
                "g df adf b er  R f SD F wr SGvwRwrvWRCVDSVsdvsDVSG R wrg WRV\n" +
                "sfejhEFJ efgWJ efjbJ ewfjhgWJEF wefi WJFB\n fbh" +
                "iKEHFW\nwefjBHJWEFBJJKSF\naksjfnkWEFB";
    }




}
