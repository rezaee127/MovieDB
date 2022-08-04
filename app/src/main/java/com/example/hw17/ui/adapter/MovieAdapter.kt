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
import com.example.hw17.models.Movie


class MovieAdapter(private val onClickTitle: (Int) -> Unit) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(MovieDiffCallback) {

    class ViewHolder(private val binding:MovieRowItemBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, onClickTitle: (Int) -> Unit)= binding.apply {
            tvTitle.text = movie.title
            tvTitle.setOnClickListener {
                onClickTitle(movie.id)
            }

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
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


    object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }

}