package com.example.m6_2_lesson_3_youtube.data.remote

import com.example.m6_2_lesson_3_youtube.data.model.PlaylistModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResults: Int = 10
    ): Call<PlaylistModel>
}