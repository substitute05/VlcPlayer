package com.videolist.yyl.ui;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.videolist.yyl.R;
import com.yyl.videolist.utils.V;
import com.yyl.videolist.video.VlcMediaView;

public class DemoActivity extends AppCompatActivity {
    VlcMediaView vlcVideoView;
//    String path = "http://localhost:8082/api/videos/test.mp4";
    String path = "https://skyclass.online/test.mp4";
//    String path = "rtmp://202.117.16.190/livepkgr/test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        vlcVideoView = V.findV(this, R.id.demo_video);
        vlcVideoView.onAttached(this);
        vlcVideoView.playVideo(path);
        getSupportActionBar().setTitle("Demo VideoPlayer");
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
            getSupportActionBar().hide();
        } else {
            getSupportActionBar().show();
        }
    }
    @Override
    public void onBackPressed() {
        if (vlcVideoView.onBackPressed(this)) return;
        super.onBackPressed();
    }
}
