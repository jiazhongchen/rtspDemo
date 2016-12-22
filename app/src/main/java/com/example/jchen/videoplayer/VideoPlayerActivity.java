package com.example.jchen.videoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    private ProgressBar proBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        setupVideoView();
    }

    private void setupVideoView() {

        final VideoView vv = (VideoView) findViewById(R.id.video_view);
        vv.setVideoURI(Uri.parse("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov"));
        vv.requestFocus();
        proBar = (ProgressBar)findViewById(R.id.proBar);
        vv.setMediaController(new MediaController(this));
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                proBar.setVisibility(View.GONE);
                vv.start();
            }
        });

    }

}
