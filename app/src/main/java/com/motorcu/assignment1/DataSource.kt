package com.motorcu.assignment1

import android.content.Context

class DataSource(val context: Context) {
    fun getMovieTitlesList(): Array<String>{
        return context.resources.getStringArray(R.array.movie_titles)
    }
    fun getGenresList(): Array<String>{
        return context.resources.getStringArray(R.array.movie_genres)
    }

    fun getReleaseDates(): Array<String>{
        return context.resources.getStringArray(R.array.movie_release_dates)
    }
    fun getDirectors(): Array<String>{
        return context.resources.getStringArray(R.array.movie_directors)
    }
    fun getRatings(): Array<String>{
        return context.resources.getStringArray(R.array.movie_ratings)
    }
    // string olan poster adlarını id'ye çeviriyor(Int)
    fun getPosterIds(): Array<Int> {
        val posterNames = context.resources.getStringArray(R.array.movie_posters)
        val defaultPosterId = R.drawable.matrix_poster // Replace with your default drawable

        return posterNames.map { posterName ->
            val resourceId = context.resources.getIdentifier(posterName, "drawable", context.packageName)
            if (resourceId != 0) resourceId else defaultPosterId
        }.toTypedArray()
    }
    fun loadMovies():List<Movie>{
        val movieTitleList=getMovieTitlesList()
        val genresList=getGenresList()
        val relaseDateList=getReleaseDates()
        val directorList= getDirectors()
        val ratingList=getRatings()

        val movies= mutableListOf<Movie>()
        val poster=getPosterIds()
        //val poster=R.drawable.movie
        for(m in movieTitleList.indices){
            movies.add(Movie(movieTitleList[m],genresList[m],relaseDateList[m],directorList[m],ratingList[m],poster[m]))
        }
        return movies
    }
}