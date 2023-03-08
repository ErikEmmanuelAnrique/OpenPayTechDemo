package com.wolox.openpaytechdemo.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wolox.openpaytechdemo.databinding.MovieViewHolderBinding
import com.wolox.openpaytechdemo.models.Movie

class MoviesListAdapter(private val dataset: List<Movie>) :
    RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        MovieViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size
}