package com.minhduc02.music.activity.customUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.constraintlayout.motion.widget.MotionLayout;

public class SongMotionLayout extends MotionLayout {

    public SongMotionLayout(Context context) {
        super(context);
    }

    public SongMotionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SongMotionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }
}
