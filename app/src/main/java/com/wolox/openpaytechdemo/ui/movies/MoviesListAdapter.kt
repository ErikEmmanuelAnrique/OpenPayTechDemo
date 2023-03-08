package com.wolox.openpaytechdemo.ui.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wolox.openpaytechdemo.databinding.MovieViewHolderBinding
import com.wolox.openpaytechdemo.models.Movie

class MoviesListAdapter(private val dataset: List<Movie>) :
    RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {



    class MovieViewHolder(private val binding: MovieViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val BASE_URL_IMG = "https://image.tmdb.org/t/p/w500"
        fun bind(item: Movie) {
            with(binding) {
                movieTitle.text = item.title
                Glide.with(binding.root)
                    .load(BASE_URL_IMG + item.posterPath)
                    .into(movieCover)
            }
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