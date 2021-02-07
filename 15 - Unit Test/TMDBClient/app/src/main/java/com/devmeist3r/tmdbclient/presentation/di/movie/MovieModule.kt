package com.devmeist3r.tmdbclient.presentation.di.movie

import com.devmeist3r.tmdbclient.domain.usecase.GetMoviesUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.devmeist3r.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
  @MovieScope
  @Provides
  fun provideMovieViewModelFactory(
    getMoviesUseCase: GetMoviesUseCase,
    updateMoviesUsecase: UpdateMoviesUseCase
  ): MovieViewModelFactory {
    return MovieViewModelFactory(
      getMoviesUseCase,
      updateMoviesUsecase
    )
  }

}
