package com.motorcu.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motorcu.assignment1.databinding.ActivityMainBinding


import androidx.recyclerview.widget.LinearLayoutManager
import com.motorcu.assignment1.Adapter.MovieAdapter
import com.motorcu.assignment1.Data.DataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movies= DataSource(this).loadMovies()

        val adapter = MovieAdapter(movies)
        binding.recycleview1.layoutManager = LinearLayoutManager(this)
        binding.recycleview1.adapter = MovieAdapter(movies)

    }
}
