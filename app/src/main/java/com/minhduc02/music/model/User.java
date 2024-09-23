package com.minhduc02.music.model;

import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private String image;
    private List<MusicItem> favoriteList;
    private List<PlayList> playlist;

    public User() {
        this.id = "";
        this.username = "";
        this.password = "";
        this.name = "";
        this.image = "";
        this.favoriteList = null;
        this.playlist = null;
    }

    public User(String id, String username, String password, String name, String image, List<MusicItem> favoriteList, List<PlayList> playlist) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.image = image;
        this.favoriteList = favoriteList;
        this.playlist = playlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<MusicItem> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<MusicItem> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public List<PlayList> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlayList> playlist) {
        this.playlist = playlist;
    }
}
