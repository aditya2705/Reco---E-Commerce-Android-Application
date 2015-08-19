package com.recommend.reco.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Abbas on 22/06/2014.
 */
public class ProductViewLarge extends RelativeLayout {

    private RelativeLayout mainLayout;
    private ImageView productImage;
    private TextView productTitle;
    private TextView productPrice;
    private TextView productDetail;
    public ProductViewLarge(Context context,AttributeSet attr) {
        super(context,attr);
        mainLayout = (RelativeLayout)RelativeLayout.inflate(context,R.layout.product_view_large,this);
        productImage = (ImageView)mainLayout.findViewById(R.id.product_image_large);
        productTitle = (TextView)mainLayout.findViewById(R.id.product_name_large);
        productPrice = (TextView)mainLayout.findViewById(R.id.product_price_large);
        productDetail = (TextView)mainLayout.findViewById(R.id.product_details);

    }

    public ProductViewLarge(Context context) {
        super(context);
        mainLayout = (RelativeLayout)RelativeLayout.inflate(context,R.layout.product_view_large,this);
        productImage = (ImageView)mainLayout.findViewById(R.id.product_image_large);
        productTitle = (TextView)mainLayout.findViewById(R.id.product_name_large);
        productPrice = (TextView)mainLayout.findViewById(R.id.product_price_large);
        productDetail = (TextView)mainLayout.findViewById(R.id.product_details);

    }



    public void fetchData()
    {

    }

    private void setProductPrice(int price)
    {
        productPrice.setText("Price: " + price);
    }
}
