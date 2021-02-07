package com.devmeist3r.tmdbclient.data.repository.tvshow.datasource

import com.devmeist3r.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
  suspend fun getTvShowsFromCache():List<TvShow>
  suspend fun saveTvShowsToCache(tvShows:List<TvShow>)

}
