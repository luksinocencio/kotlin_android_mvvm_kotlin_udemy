package com.devmeist3r.tmdbclient.domain.usecase

import com.devmeist3r.tmdbclient.data.model.movie.Movie
import com.devmeist3r.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}
