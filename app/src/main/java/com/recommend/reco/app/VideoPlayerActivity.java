package com.recommend.reco.app;

import java.io.IOException;

import android.support.v7.app.ActionBar;
import android.app.Activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class VideoPlayerActivity extends ActionBarActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, VideoControllerView.MediaPlayerControl {

    SurfaceView videoSurface;
    MediaPlayer player;
    VideoControllerView controller;
    FrameLayout videoFrame;
    ScrollView scrollView;
    SurfaceHolder videoHolder;
    FrameLayout.LayoutParams defaultParam,fullScreenParam;
    View view1,view2,view3;
    TextView video_detail_title,video_detail_author,video_detail_view_count,video_detail_like_count,video_detail_dislike_count,heading;
    ListView category_list_view,video_comment_list;
    EditText writeComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoSurface = (SurfaceView)findViewById(R.id.videoSurface);
        videoHolder = videoSurface.getHolder();
        videoHolder.addCallback(this);
        scrollView = (ScrollView)findViewById(R.id.scrollView);


        view1 = scrollView.findViewById(R.id.layout1);
        view2 = scrollView.findViewById(R.id.layout2);
        view3 = scrollView.findViewById(R.id.layout3);

        //video_detail
        video_detail_title = (TextView) view1.findViewById(R.id.video_detail_title);
        video_detail_author = (TextView) view1.findViewById(R.id.video_detail_author);
        video_detail_view_count = (TextView) view1.findViewById(R.id.video_detail_view_count);
        video_detail_like_count = (TextView) view1.findViewById(R.id.video_detail_like_count);
        video_detail_dislike_count = (TextView) view1.findViewById(R.id.video_detail_dislike_count);


        //video_category_list
        heading = (TextView) view2.findViewById(R.id.heading);
      //  category_list_view = (ListView) view2.findViewById(R.id.category_list_view);

        //video_comments
        writeComment = (EditText) view3.findViewById(R.id.writeComment);
        video_comment_list = (ListView) view3.findViewById(R.id.video_comment_list);




        fillVideoDetail();


        videoHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        controller = new VideoControllerView(this);

        player = new MediaPlayer();

        defaultParam = (FrameLayout.LayoutParams)videoSurface.getLayoutParams();
        fullScreenParam = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);


        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

            Uri video = Uri.parse("android.resource://com.recommend.reco.app/" +
                    + R.raw.mrbean);

            player.setDataSource(this,video);

            player.setOnPreparedListener(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoSurface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                controller.show();
                return false;
            }
        });
    }

    // Implement SurfaceHolder.Callback
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        player.setDisplay(holder);
        player.prepareAsync();
        Log.v("video","surface created");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    // End SurfaceHolder.Callback

    // Implement MediaPlayer.OnPreparedListener
    @Override
    public void onPrepared(MediaPlayer mp) {
        controller.setMediaPlayer(this);
        controller.setAnchorView((FrameLayout)findViewById(R.id.videoSurfaceContainer));
        Log.v("player","prepared");
        player.start();
    }
    // End MediaPlayer.OnPreparedListener

    // Implement VideoMediaController.MediaPlayerControl
    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return player.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return player.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return player.isPlaying();
    }

    @Override
    public void pause() {
        player.pause();
    }

    @Override
    public void seekTo(int i) {
        player.seekTo(i);
    }

    @Override
    public void start() {
        player.start();
    }

    @Override
    public boolean isFullScreen() {
        return getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    @Override
    public void toggleFullScreen() {
        if(!isFullScreen())
        {
            //getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        else
        {
            /*getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);*/

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }



    }
    // End VideoMediaController.MediaPlayerControl


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) //To fullscreen
        {
            Log.v("config","config landscape");
            //getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
            getSupportActionBar().hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            int height = getWindowManager().getDefaultDisplay().getHeight();
            int width = getWindowManager().getDefaultDisplay().getWidth();
            //getActivity().setContentView(R.layout.activity_main);
            videoSurface.setLayoutParams(fullScreenParam);
            videoHolder.setSizeFromLayout();
            scrollView.setVisibility(View.GONE);

        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            // no need to fullscreen
            //getActivity().setContentView(R.layout.activity_main);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().show();

            int width = getWindowManager().getDefaultDisplay().getWidth();
            float scale = getResources().getDisplayMetrics().density;
            int height = (int)(180*scale + 0.5f);
            videoSurface.setLayoutParams(defaultParam);
            videoHolder.setSizeFromLayout();
            scrollView.setVisibility(View.VISIBLE);

        }
    }

    private void fillVideoDetail() {

        video_detail_title.setText("How to spot an Idiot?");
        video_detail_author.setText("Some Idiot");
        video_detail_view_count.setText("1000");
        video_detail_like_count.setText("300");
        video_detail_dislike_count.setText("100");

    }

}

