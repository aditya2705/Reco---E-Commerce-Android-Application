package com.recommend.reco.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;


import com.recommend.reco.app.dummy.DummyContent;

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
public class ProductViewSmallFragment extends Fragment implements GridView.OnItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<ProductViewSmall> gridArray = new ArrayList<ProductViewSmall>();

    /**
     * The fragment's ListView/GridView.
     */
    private GridView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ProductViewSmallAdapter productViewSmallAdapter;

    // TODO: Rename and change types of parameters
    public static ProductViewSmallFragment newInstance(String param1, String param2) {
        ProductViewSmallFragment fragment = new ProductViewSmallFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductViewSmallFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        gridArray.add(new ProductViewSmall("Samsung",R.drawable.ic_launcher,3000));
        gridArray.add(new ProductViewSmall("Moto",R.drawable.ic_launcher,8000));
        gridArray.add(new ProductViewSmall("Karbonn",R.drawable.ic_launcher,5000));
        gridArray.add(new ProductViewSmall("Micromax",R.drawable.ic_launcher,4000));
        gridArray.add(new ProductViewSmall("HTC",R.drawable.ic_launcher,3000));
        gridArray.add(new ProductViewSmall("Sony",R.drawable.ic_launcher,1000));
        gridArray.add(new ProductViewSmall("Toshiba",R.drawable.ic_launcher,10000));
        gridArray.add(new ProductViewSmall("Nexus 4",R.drawable.ic_launcher,3000));
        gridArray.add(new ProductViewSmall("Nexus 5",R.drawable.ic_launcher,4500));

        // TODO: Change Adapter to display your content
        productViewSmallAdapter = new ProductViewSmallAdapter(getActivity(), R.layout.product_view_small, gridArray);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productviewsmall, container, false);

        // Set the adapter
        mListView = (GridView) view.findViewById(R.id.grid_view);
        mListView.setAdapter(productViewSmallAdapter);

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
            mListener.onFragmentInteraction(gridArray.get(position).toString());
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

}
