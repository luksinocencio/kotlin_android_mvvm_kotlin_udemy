package com.devmeist3r.tmdbclient.presentation.di.movie

import com.devmeist3r.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
  fun inject(movieActivity: MovieActivity)

  @Subcomponent.Factory
  interface Factory{
    fun create():MovieSubComponent
  }

}
