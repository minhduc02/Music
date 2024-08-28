package com.minhduc02.music.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.minhduc02.music.R;
import com.minhduc02.music.adapter.ViewPagerAdapter;
import com.minhduc02.music.databinding.ActivityMainBinding;
import com.minhduc02.music.extension.ViewExtension;
import com.minhduc02.music.fragment.HomeFragment;
import com.minhduc02.music.model.MusicItem;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        handleEvent();
    }

    @SuppressLint("ClickableViewAccessibility")
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