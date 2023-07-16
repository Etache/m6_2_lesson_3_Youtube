package com.example.m6_2_lesson_3_youtube.ui

import androidx.lifecycle.LiveData
import com.example.m6_2_lesson_3_youtube.core.base.BaseViewModel
import com.example.m6_2_lesson_3_youtube.core.network.Resource
import com.example.m6_2_lesson_3_youtube.data.model.PlaylistModel
import com.example.m6_2_lesson_3_youtube.repository.Repository

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    fun playlists(): LiveData<Resource<PlaylistModel>> {
        return repository.getPlaylists()
    }
}