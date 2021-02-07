package com.devmeist3r.tmdbclient.domain.repository

import com.devmeist3r.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}
