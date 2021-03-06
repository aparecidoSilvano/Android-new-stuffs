package com.example.aparecido.mymovieapp.presentation.adapter

import android.content.Context
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aparecido.mymovieapp.R.mipmap.ic_launcher
import com.example.aparecido.mymovieapp.data.entries.MovieSearch
import com.example.aparecido.mymovieapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class MoviesAdapter(private val context: Context, private val moviesList: List<MovieSearch>) :
        RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    companion object {

        private const val BASE_URL = "https://image.tmdb.org/t/p/w400/"

        @JvmStatic
        @BindingAdapter("picassoLoad")
        fun setImageUrl(imageView: ImageView, url: String?) {
            Picasso.get().load(BASE_URL + url).placeholder(ic_launcher).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val movieBinding = ItemMovieBinding.inflate(layoutInflater, parent, false)

        return MovieViewHolder(movieBinding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setData(moviesList[position])
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setData(movie: MovieSearch) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }
}