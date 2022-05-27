package com.example.hw17.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw17.R
import com.example.hw17.models.ComingSoonMovie


class ComingSoonMovieAdapter(var onClickTitle: (Int) -> Unit,var onClickPlayButton:(Int)->Unit) :
    ListAdapter<ComingSoonMovie, ComingSoonMovieAdapter.ViewHolder>(ComingSoonMovieDiffCallback) {

    class ViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        val ivMovie = view.findViewById<ImageView>(R.id.iv_movie)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val btnPlayVideo = view.findViewById<ImageButton>(R.id.ibtn_play_video)

        fun bind(comingSoonMovie: ComingSoonMovie, onClickTitle: (Int) -> Unit, onClickPlayButton:(Int)->Unit) {
            tvTitle.text = comingSoonMovie.title
            btnPlayVideo.visibility=View.GONE
            tvTitle.setOnClickListener {
                onClickTitle(comingSoonMovie.id)
            }
            btnPlayVideo.setOnClickListener {
                onClickPlayButton(comingSoonMovie.id)
            }

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/${comingSoonMovie.posterPath}")
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .fitCenter()
                .circleCrop()
                .into(ivMovie)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_row_item, viewGroup, false)

        return ViewHolder(view,viewGroup.context)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(getItem(position), onClickTitle,onClickPlayButton)

    }


    object ComingSoonMovieDiffCallback : DiffUtil.ItemCallback<ComingSoonMovie>() {
        override fun areItemsTheSame(oldItem: ComingSoonMovie, newItem: ComingSoonMovie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ComingSoonMovie, newItem: ComingSoonMovie): Boolean {
            return oldItem.id == newItem.id
        }
    }

}