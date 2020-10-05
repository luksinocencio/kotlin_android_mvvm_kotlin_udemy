package com.devmeist3r.tmdbclient.data.repository.tvshow.datasource

import com.devmeist3r.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
  suspend fun getTvShows(): Response<TvShowList>
}
