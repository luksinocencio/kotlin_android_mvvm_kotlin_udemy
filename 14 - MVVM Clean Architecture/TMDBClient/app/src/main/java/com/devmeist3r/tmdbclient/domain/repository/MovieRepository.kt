package com.devmeist3r.tmdbclient.domain.repository

import com.devmeist3r.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}
