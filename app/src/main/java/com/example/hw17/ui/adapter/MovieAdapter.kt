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
import com.example.hw17.models.Movie


class MovieAdapter(var onClickTitle: (Int) -> Unit,var onClickPlayButton:(Int)->Unit) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(MovieDiffCallback) {

    class ViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        val ivMovie = view.findViewById<ImageView>(R.id.iv_movie)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val btnPlayVideo = view.findViewById<ImageButton>(R.id.ibtn_play_video)

        fun bind(movie: Movie, onClickTitle: (Int) -> Unit,onClickPlayButton:(Int)->Unit) {
            tvTitle.text = movie.title
            tvTitle.setOnClickListener {
                onClickTitle(movie.id)
            }
            btnPlayVideo.setOnClickListener {
                onClickPlayButton(movie.id)
            }

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
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


    object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }

}