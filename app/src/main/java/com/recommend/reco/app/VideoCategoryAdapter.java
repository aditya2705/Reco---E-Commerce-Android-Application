package com.recommend.reco.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sumeet on 13-07-2014.
 */
public class VideoCategoryAdapter extends ArrayAdapter<VideoContainerItem> {
    private Context context;
    int layoutResourceId;
    private ArrayList<VideoContainerItem> list = new ArrayList<VideoContainerItem>();
    private ArrayList<VideoListItem> videoListItems = new ArrayList<VideoListItem>();

    public VideoCategoryAdapter(Context context, int resource, ArrayList<VideoContainerItem> list) {
        super(context, resource, list);
        this.list = list;
        this.layoutResourceId=resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ParentHolder holder1 = null;
        ChildHolder holder2 = null;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View videoItem;

        if (row == null) {

            row = inflater.inflate(layoutResourceId, parent, false);

            holder1 = new ParentHolder();

            holder1.heading = (TextView) row.findViewById(R.id.heading);
            holder1.linearLayout = (LinearLayout) row.findViewById(R.id.category_list_view_layout);

            row.setTag(holder1);
        } else {
            holder1 = (ParentHolder) row.getTag();
        }



        VideoContainerItem item = list.get(position);
        holder1.heading.setText(item.getHeading());

        videoListItems = item.getItems();


        for(final VideoListItem v: videoListItems){

            videoItem = inflater.inflate(R.layout.video_item,null);
            holder2 = new ChildHolder();
            holder2.videoImage = (ImageView) videoItem.findViewById(R.id.video_image);
            LinearLayout l1 = (LinearLayout) videoItem.findViewById(R.id.layout1);
            holder2.videoTitle = (TextView) l1.findViewById(R.id.video_title);
            holder2.videoUploader = (TextView) l1.findViewById(R.id.video_uploader);
            holder2.videoViews = (TextView) l1.findViewById(R.id.video_views);

            holder2.videoImage.setImageResource(v.getVideoImageID());
            holder2.videoTitle.setText(v.getVideoTitle());
            holder2.videoUploader.setText(v.getVideoUploader());
            holder2.videoViews.setText(v.getVideoViews()+" views");

            videoItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Clicked"+v.getVideoTitle(),Toast.LENGTH_SHORT-600).show();
                }
            });

            holder1.linearLayout.addView(videoItem);
        }



        return row;
    }

    static class ParentHolder {

        private TextView heading;
        private LinearLayout linearLayout;

    }

    static class ChildHolder {

        private ImageView videoImage;
        private TextView videoTitle,videoUploader,videoViews;

    }

}
