package com.minhduc02.music.epoxy;

import android.content.Context;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.SnapHelper;

import com.airbnb.epoxy.CarouselModel_;
import com.bumptech.glide.Glide;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.EpoxyController;
import com.minhduc02.music.R;
import com.minhduc02.music.databinding.ItemLoadingBinding;
import com.minhduc02.music.databinding.ItemPlaylistBinding;
import com.minhduc02.music.databinding.ItemSongBinding;
import com.minhduc02.music.model.MusicItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyEpoxyController extends EpoxyController {
    private ArrayList<MusicItem> listMusic;
    private Context context;
    private OnClickItemListener onClickItem;
    private boolean isFiltering = false;

    @Override
    protected void buildModels() {
        Carousel.setDefaultGlobalSnapHelperFactory(new Carousel.SnapHelperFactory() {
            @NonNull
            @Override
            public SnapHelper buildSnapHelper(Context context) {
                return new GravitySnapHelper(Gravity.CENTER);
            }
        });
        if (isFiltering) {
            for (MusicItem item : listMusic) {
                new MusicItemModel(context, item, onClickItem).id(item.getId()).addTo(this);
            }
            return;
        }
        List<MusicItem> listChild = new ArrayList<>();
        List<MusicItem> listLove = new ArrayList<>();
        List<MusicItem> listRemix = new ArrayList<>();

        for (MusicItem item : listMusic) {
            if ("Lofi chill".equals(item.getPlayList())) listChild.add(item);
            if ("Love".equals(item.getPlayList())) listLove.add(item);
            if ("Remix".equals(item.getPlayList())) listRemix.add(item);
        }

        new PlaylistItemModel(context, "Lofi chill").id("title_1").addTo(this);
        if (listChild.isEmpty()) {
            new LoadingItemModel().id("loading_chill").addTo(this);
        } else {
            new CarouselModel_()
                    .id("list_1")
                    .models(listChild.stream()
                            .map(item -> new MusicItemModel(context, item, onClickItem).id(item.getId()))
                            .collect(Collectors.toList()))
                    .addTo(this);
        }

        new PlaylistItemModel(context, "Love").id("title_2").addTo(this);
        if (listLove.isEmpty()) {
            new LoadingItemModel().id("loading_love").addTo(this);
        } else {
            new CarouselModel_()
                    .id("list_2")
                    .models(listLove.stream()
                            .map(item -> new MusicItemModel(context, item, onClickItem).id(item.getId()))
                            .collect(Collectors.toList()))
                    .addTo(this);
        }

        new PlaylistItemModel(context, "Remix").id("title_3").addTo(this);
        if (listRemix.isEmpty()) {
            new LoadingItemModel().id("loading_remix").addTo(this);
        } else {
            new CarouselModel_()
                    .id("list_3")
                    .models(listRemix.stream()
                            .map(item -> new MusicItemModel(context, item, onClickItem).id(item.getId()))
                            .collect(Collectors.toList()))
                    .addTo(this);
        }
    }

    public interface OnClickItemListener {
        void OnClick(MusicItem item);
    }

    public void setIsFiltering(boolean isFiltering) {
        this.isFiltering = isFiltering;
    }

    public void setListMusic(ArrayList<MusicItem> listMusic) {
        this.listMusic.clear();
        this.listMusic.addAll(listMusic);
    }

    public static class MusicItemModel extends ViewBindingModel<ItemSongBinding> {
        private final Context context;
        private final MusicItem musicItem;
        private final OnClickItemListener onClickItem;

        public MusicItemModel(Context context, MusicItem musicItem, OnClickItemListener onClickItem) {
            super(R.layout.item_song);
            this.context = context;
            this.musicItem = musicItem;
            this.onClickItem = onClickItem;
        }

        @Override
        public void bind(ItemSongBinding binding) {
            binding.tvName.setText(musicItem.getName());
            binding.tvAuthor.setText(musicItem.getAuthor());
            binding.tvName.setSelected(true);
            binding.tvAuthor.setSelected(true);
            Glide.with(context).load(musicItem.getImage()).error(R.drawable.img_error).into(binding.imgSong);
            binding.getRoot().setOnClickListener(v -> onClickItem.OnClick(musicItem));
        }
    }

    public static class PlaylistItemModel extends ViewBindingModel<ItemPlaylistBinding> {
        private final Context context;
        private final String playlistName;

        public PlaylistItemModel(Context context, String playlistName) {
            super(R.layout.item_playlist);
            this.context = context;
            this.playlistName = playlistName;
        }

        @Override
        public void bind(ItemPlaylistBinding binding) {
            binding.tvPlaylistName.setText(playlistName);
        }
    }

    public static class LoadingItemModel extends ViewBindingModel<ItemLoadingBinding> {

        public LoadingItemModel() {
            super(R.layout.item_loading);
        }

        @Override
        public void bind(ItemLoadingBinding binding) {
        }
    }

    public static MyEpoxyController newInstance(Context context, OnClickItemListener onClickItem) {
        MyEpoxyController myEpoxyController = new MyEpoxyController();
        myEpoxyController.context = context;
        myEpoxyController.listMusic = new ArrayList<>();
        myEpoxyController.onClickItem = onClickItem;
        return myEpoxyController;
    }
}
