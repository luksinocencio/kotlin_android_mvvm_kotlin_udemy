package com.devmeist3r.tmdbclient.presentation.di.artist

import com.devmeist3r.tmdbclient.domain.usecase.GetArtistsUseCase
import com.devmeist3r.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.devmeist3r.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
  @ArtistScope
  @Provides
  fun provideArtistViewModelFactory(
    getArtistsUseCase: GetArtistsUseCase,
    updateArtistsUseCase: UpdateArtistsUseCase
  ): ArtistViewModelFactory {
    return ArtistViewModelFactory(
      getArtistsUseCase,
      updateArtistsUseCase
    )
  }

}
