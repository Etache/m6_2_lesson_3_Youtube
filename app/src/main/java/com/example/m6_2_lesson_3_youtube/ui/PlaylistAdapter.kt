package com.example.m6_2_lesson_3_youtube.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.m6_2_lesson_3_youtube.data.model.PlaylistModel
import com.example.m6_2_lesson_3_youtube.databinding.ItemPlaylistBinding

class PlaylistAdapter() : RecyclerView.Adapter<PlaylistAdapter.PlayListsViewHolder>() {

    @SuppressLint("NotifiDataSetChanged")
    fun setList(liste: List<PlaylistModel.Item>){
        this.list = liste as ArrayList<PlaylistModel.Item>
        notifyDataSetChanged()
    }

    private var list = arrayListOf<PlaylistModel.Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        return PlayListsViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class PlayListsViewHolder(private val binding: ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PlaylistModel.Item) {
            binding.ivPlaylistPrev.load(item.snippet.thumbnails.default.url)
            binding.tvVideoTitle.text = item.snippet.title
            binding.tvVideoAmount.text = "${item.contentDetails.itemCount} video"
        }

    }
}