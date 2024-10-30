package com.motorcu.assignment1

// MovieAdapter.kt
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.motorcu.assignment1.databinding.ItemLayoutBinding

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                nameView.text = movie.title
                profileView.text = movie.genre


                root.setOnClickListener {
                    val context = it.context
                    val showMovieIntent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("movie_title", movie.title)
                        putExtra("movie_genre", movie.genre)
                        putExtra("movie_release_date", movie.releaseDate)
                        putExtra("movie_director", movie.director)

                        putExtra("movie_rating", movie.rating)
                        putExtra("movie_poster", movie.poster)

                    }
                    context.startActivity(showMovieIntent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size
}

