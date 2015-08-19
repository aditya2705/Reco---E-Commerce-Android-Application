package com.recommend.reco.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.LinearLayout;
import android.widget.SearchView;

/**
 * This example illustrates a common usage of the DrawerLayout widget in the Android support library.
 * <p/>
 * <p>
 * When a navigation (left) drawer is present, the host activity should detect presses of the action bar's Up affordance as a signal to open and close the navigation drawer. The ActionBarDrawerToggle
 * facilitates this behavior. Items within the drawer should fall into one of two categories:
 * </p>
 * <p/>
 * <ul>
 * <li><strong>View switches</strong>. A view switch follows the same basic policies as list or tab navigation in that a view switch does not create navigation history. This pattern should only be
 * used at the root activity of a task, leaving some form of Up navigation active for activities further down the navigation hierarchy.</li>
 * <li><strong>Selective Up</strong>. The drawer allows the user to choose an alternate parent for Up navigation. This allows a user to jump across an app's navigation hierarchy at will. The
 * application should treat this as it treats Up navigation from a different task, replacing the current task stack using TaskStackBuilder or similar. This is the only form of navigation drawer that
 * should be used outside of the root activity of a task.</li>
 * </ul>
 * <p/>
 * <p>
 * Right side drawers should be used for actions, not navigation. This follows the pattern established by the Action Bar that navigation should be to the left and actions to the right. An action
 * should be an operation performed on the current contents of the window, for example enabling or disabling a data overlay on top of the current content.
 * </p>
 */
public class MainActivity extends FragmentActivity implements ProductViewSmallFragment.OnFragmentInteractionListener,MovieItemFragment.OnFragmentInteractionListener
, HomePageFragment.OnFragmentInteractionListener, ListGenerateFragment.OnFragmentInteractionListener, VideoCategory.OnFragmentInteractionListener{



    private DrawerLayout mDrawerLayout;
    // private ListView mDrawerList;

    private ExpandableListView mDrawerList;

    private LinearLayout LeftDrawerView;

    CustomExpandAdapter customAdapter;

    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;


    private String[] Men,Women,Furniture,Electronics;


    List<DrawerItem> listParent;

    HashMap<String, List<String>> listDataChild;

    private static final String tag = "Position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();

        Men = getResources().getStringArray(R.array.men_array);
        Women = getResources().getStringArray(R.array.women_array);
        Electronics = getResources().getStringArray(R.array.electronics_array);
        Furniture = getResources().getStringArray(R.array.furniture_array);

        LeftDrawerView = (LinearLayout) findViewById(R.id.left_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList = (ExpandableListView) findViewById(R.id.expandListView);


        //Group indicator to right
/*
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            mDrawerList.setIndicatorBounds(width - GetPixelFromDips(200), width - GetPixelFromDips(10));
        } else {
            mDrawerList.setIndicatorBoundsRelative(width - GetPixelFromDips(200), width - GetPixelFromDips(10));
        }

*/
        // set a custom shadow that overlays the search_menu content when the drawer
        // opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        listParent = new ArrayList<DrawerItem>();
        listDataChild = new HashMap<String, List<String>>();

        // Navigation Drawer of Flight starts

        listParent.add(new DrawerItem(getString(R.string.rowOne),0,true));

        listParent.add(new DrawerItem(getString(R.string.rowTwo),0,true));

//        listParent.add(new DrawerItem(getString(R.string.men),R.drawable.ic_action_group,false));
//        listParent.add(new DrawerItem(getString(R.string.women),R.drawable.ic_action_group,false));
//        listParent.add(new DrawerItem(getString(R.string.elx),R.drawable.ic_action_camera,false));
//        listParent.add(new DrawerItem(getString(R.string.fur),R.drawable.ic_action_cloud,false));
        listParent.add(new DrawerItem(getString(R.string.rowFour),0,true));
        listParent.add(new DrawerItem(getString(R.string.tvshows),R.drawable.ic_action_good,false));


//        listParent.add(new DrawerItem(getString(R.string.rowThree),0,true));


//        listParent.add(new DrawerItem(getString(R.string.product),R.drawable.ic_action_search,false));
        listParent.add(new DrawerItem(getString(R.string.movie),R.drawable.ic_action_good,false));
/*
        listParent.add(new DrawerItem(getString(R.string.rowFive),0,true));

        listParent.add(new DrawerItem(getString(R.string.rowSix),0,true));

        listParent.add(new DrawerItem(getString(R.string.rowSeven),0,true));
*/
        listDataChild.put(getString(R.string.rowOne), new ArrayList<String>());
        listDataChild.put(getString(R.string.rowTwo), new ArrayList<String>());
//        listDataChild.put(getString(R.string.rowThree), new ArrayList<String>());
        listDataChild.put(getString(R.string.rowFour), new ArrayList<String>());
  //      listDataChild.put(getString(R.string.rowFive), new ArrayList<String>());
  //      listDataChild.put(getString(R.string.rowSix), new ArrayList<String>());
  //      listDataChild.put(getString(R.string.rowSeven), new ArrayList<String>());
 //       listDataChild.put(getString(R.string.product), new ArrayList<String>());
        listDataChild.put(getString(R.string.movie), new ArrayList<String>());
        listDataChild.put(getString(R.string.tvshows), new ArrayList<String>());

//        listDataChild.put(getString(R.string.men), Arrays.asList(Men));
//        listDataChild.put(getString(R.string.women), Arrays.asList(Women));
//        listDataChild.put(getString(R.string.elx), Arrays.asList(Electronics));
//        listDataChild.put(getString(R.string.fur), Arrays.asList(Furniture));

        customAdapter = new CustomExpandAdapter(this, listParent, listDataChild);


        // setting list adapter
        mDrawerList.setAdapter(customAdapter);
        mDrawerList.setChoiceMode(ExpandableListView.CHOICE_MODE_SINGLE);


        // // set up the drawer's list view with items and click listener
        // mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, ElectronicTitles));
        // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
                mDrawerLayout, /* DrawerLayout object */
                R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
                R.string.navigation_drawer_open, /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItemChild(0);
        }

        Fragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        mTitle = "Feed";
        mDrawerList.setItemChecked(0, true);
    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mDrawerList.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(groupPosition));
                parent.setItemChecked(index, true);


                    selectItemParent(groupPosition);

                return false;
            }
        });

        mDrawerList.setOnChildClickListener(new OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Log.d("CHECK", "child click");

                int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
                parent.setItemChecked(index, true);


                selectItemChild(childPosition);

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content
        // view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(LeftDrawerView);
        menu.findItem(R.id.search).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //
    // /* The click listner for ListView in the navigation drawer */
    // private class DrawerItemClickListener implements ListView.OnItemClickListener {
    // @Override
    // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    // selectItemChild(position);
    // }
    // }

    private void selectItemChild(int position) {



    }

    private void selectItemParent(int position) {

        Log.v(tag,""+position);
        // update the main content by replacing fragments
        Fragment fragment;
        Bundle args = new Bundle();
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position){


            case 0:
                fragment = new HomePageFragment();
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                mTitle = "Feed";
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(LeftDrawerView);
                break;

            case 1:
                fragment = new ProductViewLargeFragment();
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                mTitle = "Shop By Store";
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(LeftDrawerView);
                break;


            case 2:
                fragment = new VideoCategory();
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                mTitle = "Recommended";
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(LeftDrawerView);
                break;

            case 3:
                Intent intent = new Intent(this, VideoPlayerActivity.class);
                MainActivity.this.startActivity(intent);
                mTitle="Videos";
                break;


            case 4:
                fragment = new MovieTabFragment();
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                mTitle = "Movies";
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(LeftDrawerView);
                break;
        }



    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
