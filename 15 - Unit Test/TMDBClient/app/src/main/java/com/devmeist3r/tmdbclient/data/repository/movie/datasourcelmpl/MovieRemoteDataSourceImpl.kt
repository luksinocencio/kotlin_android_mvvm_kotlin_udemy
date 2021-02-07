package com.devmeist3r.tmdbclient.data.repository.movie.datasourcelmpl

import com.devmeist3r.tmdbclient.data.api.TMDBService
import com.devmeist3r.tmdbclient.data.model.movie.MovieList
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}
