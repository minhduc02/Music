package com.minhduc02.music.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.minhduc02.music.R;
import com.minhduc02.music.databinding.FragmentHomeBinding;
import com.minhduc02.music.model.MusicItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding = null;
    private FragmentHomeBinding getBinding() {
        if (binding == null) {
            throw new IllegalStateException("_binding is null");
        }
        return binding;
    }
    private final ArrayList<MusicItem> listMusic = new ArrayList<>();
    //private MyEpoxyController myController;
    private boolean isFiltering = false;
    private boolean isFragmentRunning = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return getBinding().getRoot();
    }

    public MusicItem getSongById(String id) {
        MusicItem musicItem = new MusicItem();
        for (MusicItem item : listMusic) {
            if (item.equals(id)) {
                musicItem = item;
                break;
            }
        }
        return musicItem;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupView();

    }

    private void setupView() {

    }
}
