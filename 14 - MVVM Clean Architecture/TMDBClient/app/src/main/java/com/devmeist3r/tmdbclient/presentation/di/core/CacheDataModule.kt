package com.devmeist3r.tmdbclient.presentation.di.core

import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.devmeist3r.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.devmeist3r.tmdbclient.data.repository.movie.datasourcelmpl.MovieCacheDataSourceImpl
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
  @Singleton
  @Provides
  fun provideMovieCacheDataSource(): MovieCacheDataSource {
    return MovieCacheDataSourceImpl()
  }

  @Singleton
  @Provides
  fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
    return TvShowCacheDataSourceImpl()
  }

  @Singleton
  @Provides
  fun provideArtistCacheDataSource(): ArtistCacheDataSource {
    return ArtistCacheDataSourceImpl()
  }

}
