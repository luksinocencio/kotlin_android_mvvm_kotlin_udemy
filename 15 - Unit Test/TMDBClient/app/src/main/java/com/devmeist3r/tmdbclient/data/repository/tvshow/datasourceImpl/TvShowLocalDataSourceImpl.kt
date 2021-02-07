package com.devmeist3r.tmdbclient.data.repository.tvshow.datasourceImpl

import com.devmeist3r.tmdbclient.data.db.TvShowDao
import com.devmeist3r.tmdbclient.data.model.tvshow.TvShow
import com.devmeist3r.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvDao: TvShowDao):
  TvShowLocalDataSource {
  override suspend fun getTvShowsFromDB(): List<TvShow> {
    return tvDao.getTvShows()
  }

  override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
    CoroutineScope(Dispatchers.IO).launch {
      tvDao.saveTvShow(tvShows)
    }
  }

  override suspend fun clearAll() {
    CoroutineScope(Dispatchers.IO).launch {
      tvDao.deleteAllTvShows()
    }
  }
}
