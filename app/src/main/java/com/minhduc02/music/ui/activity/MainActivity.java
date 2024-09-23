package com.minhduc02.music.ui.activity;

import androidx.constraintlayout.motion.widget.MotionLayout;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.google.firebase.auth.FirebaseAuth;
import com.minhduc02.music.R;
import com.minhduc02.music.databinding.ActivityMainBinding;
import com.minhduc02.music.extension.ViewExtension;
import com.minhduc02.music.model.MusicItem;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;
    private final String ACTION_PREVIOUS = "ACTION_PREVIOUS";
    private final String ACTION_PLAY_PAUSE = "ACTION_PLAY_PAUSE";
    private final String ACTION_NEXT = "ACTION_NEXT";
    //private MyService myService = null;
    private final boolean isServiceConnected = false;
    private final Handler uiUpdateHandler = new Handler(Looper.getMainLooper());
    private final ArrayList<MusicItem> curPlayingList = new ArrayList<>();
    private final ArrayList<MusicItem> listBeforeShuffle = new ArrayList<>();
    private final ArrayList<MusicItem> favoriteList = new ArrayList<>();
    private final MusicItem curSong = new MusicItem();
    private final int curPosInPlayList = 0;
    private final int curRepeat = 0;
    private FirebaseAuth auth;
    private final boolean isPlayingFavorite = false;
    private final int curFragment = 0;
    private boolean isInStatePlaying = false;

    private BroadcastReceiver musicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        handleEvent();
    }
    public void initData(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_PREVIOUS);
        intentFilter.addAction(ACTION_PLAY_PAUSE);
        intentFilter.addAction(ACTION_NEXT);
        registerReceiver(musicReceiver, intentFilter);
    }

    private void handleEvent() {
        mainBinding.rootView.addTransitionListener(new MotionLayout.TransitionListener() {
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                // Implement logic if needed
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                // Implement logic if needed
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                isInStatePlaying = currentId == R.id.start;
                ViewExtension.isUserInteractionEnabled(mainBinding.fragmentContainer, !isInStatePlaying);
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
                // Implement logic if needed
            }
        });
    }

}