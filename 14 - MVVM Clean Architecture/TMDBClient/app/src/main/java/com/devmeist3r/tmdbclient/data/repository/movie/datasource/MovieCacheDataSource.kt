package com.devmeist3r.tmdbclient.data.repository.movie.datasource

import com.devmeist3r.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}
