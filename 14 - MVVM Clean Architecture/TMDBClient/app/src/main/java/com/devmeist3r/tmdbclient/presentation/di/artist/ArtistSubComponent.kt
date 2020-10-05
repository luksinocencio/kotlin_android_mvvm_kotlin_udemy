package com.devmeist3r.tmdbclient.presentation.di.artist

import com.devmeist3r.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
  fun inject(artistActivity: ArtistActivity)

  @Subcomponent.Factory
  interface Factory{
    fun create():ArtistSubComponent
  }

}
