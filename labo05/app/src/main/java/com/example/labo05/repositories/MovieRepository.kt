package com.example.labo05.repositories

import com.example.labo05.data.category
import com.example.labo05.data.description
import com.example.labo05.data.model.MovieModel
import com.example.labo05.data.name
import com.example.labo05.data.qualification

class MovieRepository (private val movies: MutableList<MovieModel>){
fun getMovies()=movies

fun addMovies(movie: MovieModel)= movies.add(movie)
}


