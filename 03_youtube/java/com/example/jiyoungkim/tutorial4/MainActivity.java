package com.example.jiyoungkim.tutorial4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class MainActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void videoClick(View v) {
        VideoView videoView = (VideoView) findViewById(R.id.video);
        String videoPath ="android.resource://com.example.jiyoungkim.tutorial4/" + R.raw.sample_video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        //미디어컨트롤러 추가
        MediaController controller = new MediaController(MainActivity.this);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);

        //비디오 시작
        videoView.start();
    }

    public void videoClick2(View v) {
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.video2);
        YouTubePlayer.OnInitializedListener onInitializedListener;

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("aatr_2MstrI");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize("AIzaSyADln0y9sX7_523fQZDTYdMlJgZ2DYZ40s", onInitializedListener);
    }
}

