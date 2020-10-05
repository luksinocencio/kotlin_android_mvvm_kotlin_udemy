package com.devmeist3r.tmdbclient.presentation.di.tvshow

import com.devmeist3r.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.devmeist3r.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides



@Module
class TvShowModule {
  @TvShowScope
  @Provides
  fun provideTvShowViewModelFactory(
    getTvShowsUseCase: GetTvShowsUseCase,
    updateTvShowsUseCase: UpdateTvShowsUseCase
  ): TvShowViewModelFactory {
    return TvShowViewModelFactory(
      getTvShowsUseCase,
      updateTvShowsUseCase
    )
  }

}
