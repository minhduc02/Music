package com.minhduc02.music.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.minhduc02.music.R;
import com.minhduc02.music.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}