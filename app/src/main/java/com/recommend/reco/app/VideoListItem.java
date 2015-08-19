package com.recommend.reco.app;

import android.content.Context;

/**
 * Created by Sumeet on 12-07-2014.
 */
public class VideoListItem {

    int videoImageID;
    String videoTitle,videoViews,videoUploader;

    public VideoListItem(String videoTitle,String videoUploader, String videoViews, int videoImageID){

        this.videoTitle=videoTitle;
        this.videoViews=videoViews;
        this.videoUploader=videoUploader;
        this.videoImageID=videoImageID;
    }

    public int getVideoImageID() {
        return videoImageID;
    }

    public void setVideoImageID(int videoImageID) {
        this.videoImageID = videoImageID;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoViews() {
        return videoViews;
    }

    public void setVideoViews(String videoViews) {
        this.videoViews = videoViews;
    }

    public String getVideoUploader() {
        return videoUploader;
    }

    public void setVideoUploader(String videoUploader) {
        this.videoUploader = videoUploader;
    }


}
