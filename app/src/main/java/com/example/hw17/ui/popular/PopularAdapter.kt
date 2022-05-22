package com.example.hw17.ui.popular


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw17.R
import com.example.hw17.models.Popular


class PopularAdapter(var onClickItem: (Int) -> Unit) :
    ListAdapter<Popular, PopularAdapter.ViewHolder>(PopularDiffCallback) {

    class ViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        val ivMovie = view.findViewById<ImageView>(R.id.iv_movie)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)

        fun bind(popular: Popular, onClickItem: (Int) -> Unit) {
            tvTitle.text = popular.title

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/${popular.posterPath}")
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

        viewHolder.bind(getItem(position), onClickItem)

    }


    object PopularDiffCallback : DiffUtil.ItemCallback<Popular>() {
        override fun areItemsTheSame(oldItem: Popular, newItem: Popular): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Popular, newItem: Popular): Boolean {
            return oldItem.id == newItem.id
        }
    }

}