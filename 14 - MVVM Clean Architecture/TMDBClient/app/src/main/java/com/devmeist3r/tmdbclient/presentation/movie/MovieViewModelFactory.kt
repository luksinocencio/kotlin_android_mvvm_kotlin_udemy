package com.devmeist3r.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devmeist3r.tmdbclient.domain.usecase.GetMoviesUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
  private val getMoviesUseCase: GetMoviesUseCase,
  private val updateMoviesUsecase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return MovieViewModel(getMoviesUseCase,updateMoviesUsecase) as T
  }
}
