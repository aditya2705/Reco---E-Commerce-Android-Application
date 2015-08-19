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
public class ProductViewSmallAdapter extends ArrayAdapter<ProductViewSmall> {
    Context context;
    int layoutResourceId;
    ArrayList<ProductViewSmall> data = new ArrayList<ProductViewSmall>();

    public ProductViewSmallAdapter(Context context, int layoutResourceId,
                                   ArrayList<ProductViewSmall> data) {
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
            holder.productImage = (ImageView) row.findViewById(R.id.productImage);

            LinearLayout l1 = (LinearLayout) row.findViewById(R.id.productDetails1);
            LinearLayout l2 = (LinearLayout) l1.findViewById(R.id.productDetails2);

            holder.productTitle = (TextView) l2.findViewById(R.id.product_name);

            LinearLayout l3 = (LinearLayout) row.findViewById(R.id.productDetails1);
            LinearLayout l4 = (LinearLayout) l3.findViewById(R.id.productDetails2);
            holder.productPrice = (TextView) l4.findViewById(R.id.product_price);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        ProductViewSmall item = data.get(position);
        holder.productTitle.setText(item.getTitle());
        holder.productImage.setImageResource(item.getResID());
        holder.productPrice.setText("Price: " + item.getPrice());

        return row;

    }

    static class RecordHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;

    }
}
