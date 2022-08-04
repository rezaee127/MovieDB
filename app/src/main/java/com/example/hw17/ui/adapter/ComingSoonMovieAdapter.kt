package com.example.hw17.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw17.R
import com.example.hw17.databinding.MovieRowItemBinding
import com.example.hw17.models.ComingSoonMovie


class ComingSoonMovieAdapter(private val onClickTitle: (Int) -> Unit) :
    ListAdapter<ComingSoonMovie, ComingSoonMovieAdapter.ViewHolder>(ComingSoonMovieDiffCallback) {

    class ViewHolder(private val binding:MovieRowItemBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comingSoonMovie: ComingSoonMovie, onClickTitle: (Int) -> Unit)
        = binding.apply{
            tvTitle.text = comingSoonMovie.title
            tvTitle.setOnClickListener {
                onClickTitle(comingSoonMovie.id)
            }

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${comingSoonMovie.posterPath}")
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .fitCenter()
                .into(ivMovie)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val binding = MovieRowItemBinding.inflate(LayoutInflater.from(viewGroup.context)
            , viewGroup, false)

        return ViewHolder(binding,viewGroup.context)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(getItem(position), onClickTitle)

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