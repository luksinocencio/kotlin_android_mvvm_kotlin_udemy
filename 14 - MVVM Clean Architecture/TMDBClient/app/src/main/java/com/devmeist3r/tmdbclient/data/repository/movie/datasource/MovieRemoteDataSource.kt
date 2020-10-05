package com.devmeist3r.tmdbclient.data.repository.movie.datasource

import com.devmeist3r.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}
