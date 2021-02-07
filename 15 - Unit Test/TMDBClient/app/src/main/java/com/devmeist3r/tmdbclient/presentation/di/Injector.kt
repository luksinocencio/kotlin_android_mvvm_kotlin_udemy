package com.devmeist3r.tmdbclient.presentation.di

import com.devmeist3r.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.devmeist3r.tmdbclient.presentation.di.movie.MovieSubComponent
import com.devmeist3r.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
  fun createMovieSubComponent():MovieSubComponent
  fun createTvShowSubComponent():TvShowSubComponent
  fun createArtistSubComponent():ArtistSubComponent
}
