package com.recommend.reco.app;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @author Sumeet
 *
 */
public class MovieItemAdapter extends ArrayAdapter<MovieItem> {
    Context context;
    int layoutResourceId;
    ArrayList<MovieItem> data = new ArrayList<MovieItem>();

    public MovieItemAdapter(Context context, int layoutResourceId,
                                   ArrayList<MovieItem> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.movieImage = (ImageView) row.findViewById(R.id.movieImage);

            LinearLayout l1 = (LinearLayout) row.findViewById(R.id.movieDetails1);
            LinearLayout l2 = (LinearLayout) l1.findViewById(R.id.movieDetails2);

            holder.movieTitle = (TextView) l2.findViewById(R.id.movie_name);

            LinearLayout l3 = (LinearLayout) row.findViewById(R.id.movieDetails1);
            LinearLayout l4 = (LinearLayout) l3.findViewById(R.id.movieDetails2);
            holder.movieCategory = (TextView) l4.findViewById(R.id.movie_category);

            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        if(position == data.size() -1)
        {

            //adding two movies at every extra scroll
            data.add(new MovieItem("Inception", "Suspense", R.drawable.ic_launcher, 5, 30));
            data.add(new MovieItem("OtherMovie", "Suspense", R.drawable.ic_launcher, 5, 30));

            notifyDataSetChanged();
        }

        MovieItem item = data.get(position);
        holder.movieImage.setImageResource(item.getMovieImageID());
        holder.movieTitle.setText(item.getMovietitle());
        holder.movieCategory.setText(item.getMovieCategory());

        item = data.get(position+1);
        holder.movieImage.setImageResource(item.getMovieImageID());
        holder.movieTitle.setText(item.getMovietitle());
        holder.movieCategory.setText(item.getMovieCategory());

        return row;

    }

    static class RecordHolder {

        private ImageView movieImage;
        private TextView movieTitle,movieCategory;

    }
}
