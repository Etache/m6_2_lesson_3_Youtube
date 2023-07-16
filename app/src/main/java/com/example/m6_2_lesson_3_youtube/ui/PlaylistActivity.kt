package com.example.m6_2_lesson_3_youtube.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m6_2_lesson_3_youtube.R
import com.example.m6_2_lesson_3_youtube.core.network.Resource
import com.example.m6_2_lesson_3_youtube.core.network.Resource.Status

class PlaylistActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_playlist)
        adapter = PlaylistAdapter()
        recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        viewModel.playlists().observe(this) { resource ->
            if (resource.status == Resource.Status.SUCCESS) {
                resource.data?.let { playlistModel ->
                    adapter.setList(playlistModel.items)
                }
            }
        }
    }
}