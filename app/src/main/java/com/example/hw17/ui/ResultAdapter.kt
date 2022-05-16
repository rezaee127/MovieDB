package com.example.hw17.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw17.R

class ResultAdapter(var onClickItem: (Int) -> Unit) :
    ListAdapter<com.example.hw17.models.Result, ResultAdapter.ViewHolder>(ResultDiffCallback) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivMovie = view.findViewById<TextView>(R.id.iv_movie)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val movieRowItems = view.findViewById<View>(R.id.movie_row_item)

        fun bind(result:com.example.hw17.models.Result, onClickItem: (Int) -> Unit) {
            tvTitle.text = result.original_title
            movieRowItems.setOnClickListener {
                onClickItem(result.id)
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(getItem(position), onClickItem)

    }


    object ResultDiffCallback : DiffUtil.ItemCallback<com.example.hw17.models.Result>() {
        override fun areItemsTheSame(oldItem: com.example.hw17.models.Result, newItem: com.example.hw17.models.Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: com.example.hw17.models.Result, newItem: com.example.hw17.models.Result): Boolean {
            return oldItem.id == newItem.id
        }
    }

}