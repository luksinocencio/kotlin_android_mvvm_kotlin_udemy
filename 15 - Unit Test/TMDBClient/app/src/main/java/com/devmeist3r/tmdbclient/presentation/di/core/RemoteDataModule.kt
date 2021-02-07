package com.devmeist3r.tmdbclient.presentation.di.core

import com.devmeist3r.tmdbclient.data.api.TMDBService
import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.devmeist3r.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.devmeist3r.tmdbclient.data.repository.movie.datasourcelmpl.MovieRemoteDataSourceImpl
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
  @Singleton
  @Provides
  fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
    return MovieRemoteDataSourceImpl(
      tmdbService, apiKey
    )
  }

  @Singleton
  @Provides
  fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
    return TvShowRemoteDataSourceImpl(
      tmdbService, apiKey
    )
  }

  @Singleton
  @Provides
  fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
    return ArtistRemoteDataSourceImpl(
      tmdbService, apiKey
    )
  }


}
