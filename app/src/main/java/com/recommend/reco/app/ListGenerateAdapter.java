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
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 *
 * @author Sumeet
 *
 */
public class ListGenerateAdapter extends ArrayAdapter<String> {
    Context context;
    int layoutResourceId;
    ArrayList<String> data = new ArrayList<String>();

    public ListGenerateAdapter(Context context, int layoutResourceId,
                                   ArrayList<String> data) {
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

            RelativeLayout r1 = (RelativeLayout) row.findViewById(R.id.item_container);

            holder.list_details = (TextView) r1.findViewById(R.id.list_item_details);

            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        holder.list_details.setText(data.get(position));

        return row;

    }

    static class RecordHolder {

        private TextView list_details;
    }
}
