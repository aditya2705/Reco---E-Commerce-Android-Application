package com.recommend.reco.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * TODO: document your custom view class.
 */
public class VideoContainerItem{



    private String heading;
    private ArrayList<VideoListItem>items = new ArrayList<VideoListItem>();

    public VideoContainerItem(String heading,ArrayList<VideoListItem> items){
        this.items = items;
        this.heading = heading;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public ArrayList<VideoListItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<VideoListItem> items) {
        this.items = items;
    }





}
