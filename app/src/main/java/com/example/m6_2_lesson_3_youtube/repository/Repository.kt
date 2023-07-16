package com.example.m6_2_lesson_3_youtube.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.m6_2_lesson_3_youtube.BuildConfig
import com.example.m6_2_lesson_3_youtube.core.network.Resource
import com.example.m6_2_lesson_3_youtube.core.network.RetrofitClient
import com.example.m6_2_lesson_3_youtube.data.model.PlaylistModel
import com.example.m6_2_lesson_3_youtube.data.remote.ApiService
import com.example.m6_2_lesson_3_youtube.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService: ApiService = RetrofitClient.create()

    fun getPlaylists(): LiveData<Resource<PlaylistModel>> {
        val data = MutableLiveData<Resource<PlaylistModel>>()

        data.value = Resource.loading()

        apiService.getPlayLists(
            part = Constants.PART,
            channelId = Constants.CHANNELID,
            apiKey = BuildConfig.API_KEY,
            maxResults = 10,
        ).enqueue(object: Callback<PlaylistModel> {
            override fun onResponse(call: Call<PlaylistModel>, response: Response<PlaylistModel>) {
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<PlaylistModel>, t: Throwable) {
                Resource.error(t.message.toString(), null)
            }

        })
        return data
    }
}