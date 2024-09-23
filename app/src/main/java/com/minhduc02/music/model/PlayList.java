package com.minhduc02.music.model;

import java.util.List;

public class PlayList {
    private int id;
    private String playListName;
    private List<MusicItem> items;

    public PlayList(int id, String playListName, List<MusicItem> items) {
        this.id = id;
        this.playListName = playListName;
        this.items = items;
    }

    public PlayList(int id, String playListName) {
        this(id, playListName, null);
    }

    public List<MusicItem> getItems() {
        return items;
    }

    public void setItems(List<MusicItem> items) {
        this.items = items;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
