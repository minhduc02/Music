package com.minhduc02.music.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class MusicItem {
    private int id;
    private String name;
    private String author;
    private String playList;
    private String image;
    private String src;
    private boolean isFavorite;

    public MusicItem(int id, boolean isFavorite, String author, String name, String playList, String src, String image) {
        this.id = id;
        this.isFavorite = isFavorite;
        this.author = author;
        this.name = name;
        this.playList = playList;
        this.src = src;
        this.image = image;
    }

    public MusicItem() {
        this.id = 0;
        this.name = null;
        this.author = null;
        this.playList = null;
        this.image = null;
        this.src = null;
        this.isFavorite = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlayList() {
        return playList;
    }

    public void setPlayList(String playList) {
        this.playList = playList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
