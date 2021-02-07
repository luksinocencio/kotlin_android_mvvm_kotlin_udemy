package com.devmeist3r.tmdbclient.data.repository.movie

import com.devmeist3r.tmdbclient.data.model.movie.Movie
import com.devmeist3r.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {

  private val movies = mutableListOf<Movie>()

  init {
    movies.add(
      Movie(1, "overview", "posterPath1", "date1", "title1")
    )
    movies.add(
      Movie(2, "overview", "posterPath2", "date2", "title2")
    )
  }

  override suspend fun getMovies(): List<Movie>? {
    return movies
  }

  override suspend fun updateMovies(): List<Movie>? {
    movies.clear()
    movies.add(
      Movie(3, "overview", "posterPath3", "date3", "title3")
    )
    movies.add(
      Movie(4, "overview", "posterPath4", "date4", "title4")
    )

    return movies
  }


}
