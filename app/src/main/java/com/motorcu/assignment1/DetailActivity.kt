package com.motorcu.assignment1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.motorcu.assignment1.databinding.ActivityDetailBinding
import com.motorcu.assignment1.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val title = intent.getStringExtra("movie_title")
        val genre = intent.getStringExtra("movie_genre")
        val releaseDate = intent.getStringExtra("movie_release_date")
        val director = intent.getStringExtra("movie_director")

        val rating = intent.getStringExtra("movie_rating")
        val poster = intent.getIntExtra("movie_poster", R.drawable.movie)

        binding.apply {
            titleTextView.text = title
            genreTextView.text = genre
            releaseDateTextView.text = releaseDate
            directorTextView.text = director

            ratingTextView.text = rating
            posterImageView.setImageResource(poster)//resim ekliyor

        }

    }
}