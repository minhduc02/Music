package com.minhduc02.music.adapter;

import com.minhduc02.music.model.MusicItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("getMusic")
    Call<List<MusicItem>> getSongs();
}
