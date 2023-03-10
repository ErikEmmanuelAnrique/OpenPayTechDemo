package com.wolox.openpaytechdemo.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wolox.openpaytechdemo.databinding.MovieViewHolderBinding
import com.wolox.openpaytechdemo.models.Movie

class MoviesListAdapter() :
    ListAdapter<Movie, MoviesListAdapter.MovieViewHolder>(MoviesCallback) {
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
        holder.bind(currentList[position])
    }

    object MoviesCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
            oldItem == newItem
    }
}

