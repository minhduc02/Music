package com.minhduc02.music.extension;

import android.view.View;
import android.view.ViewGroup;

import android.view.View;
import android.view.ViewGroup;

public class ViewExtension {

    public static void isUserInteractionEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View child = viewGroup.getChildAt(i);
                    isUserInteractionEnabled(child, enabled);
                }
            }
        }
    }
}
