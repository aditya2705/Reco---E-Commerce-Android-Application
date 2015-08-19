package com.recommend.reco.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Abbas on 24/06/2014.
 */
public class ProductViewLargeAdapter extends ArrayAdapter<String> {
    private Context context;
    private  List<String> list;
    public ProductViewLargeAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = new ProductViewLarge(context);

        if(position == list.size() -1)
        {
            list.add("xyz");
            notifyDataSetChanged();
        }

        return rowView;
    }

}
