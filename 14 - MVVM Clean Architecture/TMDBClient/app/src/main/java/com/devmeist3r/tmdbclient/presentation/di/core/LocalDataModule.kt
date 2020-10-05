package com.devmeist3r.tmdbclient.presentation.di.core

import com.devmeist3r.tmdbclient.data.db.ArtistDao
import com.devmeist3r.tmdbclient.data.db.MovieDao
import com.devmeist3r.tmdbclient.data.db.TvShowDao
import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.devmeist3r.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.devmeist3r.tmdbclient.data.repository.movie.datasourcelmpl.MovieLocalDataSourceImpl
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

  @Singleton
  @Provides
  fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
    return MovieLocalDataSourceImpl(movieDao)
  }

  @Singleton
  @Provides
  fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
    return TvShowLocalDataSourceImpl(tvShowDao)
  }

  @Singleton
  @Provides
  fun provideArtistLocalDataSource(artistDao : ArtistDao):ArtistLocalDataSource{
    return ArtistLocalDataSourceImpl(artistDao)
  }
}
