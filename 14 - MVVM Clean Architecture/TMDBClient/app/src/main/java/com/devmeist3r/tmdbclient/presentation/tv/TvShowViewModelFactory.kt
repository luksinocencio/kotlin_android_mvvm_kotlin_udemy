package com.devmeist3r.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.devmeist3r.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateTvShowsUseCase


class TvShowViewModelFactory(
  private val getTvShowsUseCase: GetTvShowsUseCase,
  private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return TvShowViewModel(
      getTvShowsUseCase,
      updateTvShowsUseCase
    ) as T
  }
}
