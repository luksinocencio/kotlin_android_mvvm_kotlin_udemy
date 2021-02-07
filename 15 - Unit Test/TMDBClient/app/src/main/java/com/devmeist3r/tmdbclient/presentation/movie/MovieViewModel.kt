package com.devmeist3r.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.devmeist3r.tmdbclient.domain.usecase.GetMoviesUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
  private val getMoviesUseCase: GetMoviesUseCase,
  private val updateMoviesUsecase: UpdateMoviesUseCase
) : ViewModel() {

  fun getMovies() = liveData {
    val movieList = getMoviesUseCase.execute()
    emit(movieList)
  }

  fun updateMovies() = liveData {
    val movieList = updateMoviesUsecase.execute()
    emit(movieList)
  }

}
