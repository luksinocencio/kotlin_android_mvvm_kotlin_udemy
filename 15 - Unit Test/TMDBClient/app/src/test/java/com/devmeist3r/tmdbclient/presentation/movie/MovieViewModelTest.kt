package com.devmeist3r.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devmeist3r.tmdbclient.data.model.movie.Movie
import com.devmeist3r.tmdbclient.data.repository.movie.FakeMovieRepository
import com.devmeist3r.tmdbclient.domain.usecase.GetMoviesUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateMoviesUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  private lateinit var viewModel: MovieViewModel

  @Before
  fun setUp() {
    val fakeMovieRepository = FakeMovieRepository()
    val getMovieUseCase = GetMoviesUseCase(fakeMovieRepository)
    val updateMovieUseCase = UpdateMoviesUseCase(fakeMovieRepository)
    viewModel = MovieViewModel(getMovieUseCase, updateMovieUseCase)
  }

  @Test
  fun getMovies_returnsCurrentList() {
    val movies = mutableListOf<Movie>()
    movies.add(
      Movie(1, "overview", "posterPath1", "date1", "title1")
    )
    movies.add(
      Movie(2, "overview", "posterPath2", "date2", "title2")
    )
  }
}
