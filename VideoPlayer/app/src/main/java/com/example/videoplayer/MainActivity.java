package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_video_view);

        VideoView simpleVideoView = findViewById(R.id.simpleVideoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        simpleVideoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        simpleVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(simpleVideoView);
    }
}