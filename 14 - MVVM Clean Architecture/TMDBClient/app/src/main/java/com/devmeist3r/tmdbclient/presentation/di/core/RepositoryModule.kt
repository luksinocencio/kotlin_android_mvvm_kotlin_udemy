package com.devmeist3r.tmdbclient.presentation.di.core

import com.devmeist3r.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.devmeist3r.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.devmeist3r.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.devmeist3r.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.devmeist3r.tmdbclient.domain.repository.ArtistRepository
import com.devmeist3r.tmdbclient.domain.repository.MovieRepository
import com.devmeist3r.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

  @Provides
  @Singleton
  fun provideMovieRepository(
    movieRemoteDatasource: MovieRemoteDataSource,
    movieLocalDataSource: MovieLocalDataSource,
    movieCacheDataSource: MovieCacheDataSource
  ): MovieRepository {

    return MovieRepositoryImpl(
      movieRemoteDatasource,
      movieLocalDataSource,
      movieCacheDataSource
    )


  }

  @Provides
  @Singleton
  fun provideTvShowRepository(
    tvShowRemoteDatasource: TvShowRemoteDatasource,
    tvShowLocalDataSource: TvShowLocalDataSource,
    tvShowCacheDataSource: TvShowCacheDataSource
  ): TvShowRepository {

    return TvShowRepositoryImpl(
      tvShowRemoteDatasource,
      tvShowLocalDataSource,
      tvShowCacheDataSource
    )


  }

  @Provides
  @Singleton
  fun provideArtistRepository(
    artistRemoteDatasource: ArtistRemoteDatasource,
    artistLocalDataSource: ArtistLocalDataSource,
    artistCacheDataSource: ArtistCacheDataSource
  ): ArtistRepository {

    return ArtistRepositoryImpl(
      artistRemoteDatasource,
      artistLocalDataSource,
      artistCacheDataSource
    )


  }

}
