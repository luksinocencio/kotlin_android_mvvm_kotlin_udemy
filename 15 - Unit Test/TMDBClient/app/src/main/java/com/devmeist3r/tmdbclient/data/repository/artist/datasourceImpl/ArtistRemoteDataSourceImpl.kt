package com.devmeist3r.tmdbclient.data.repository.artist.datasourceImpl

import com.devmeist3r.tmdbclient.data.api.TMDBService
import com.devmeist3r.tmdbclient.data.model.artist.ArtistList
import com.devmeist3r.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
  private val tmdbService: TMDBService,
  private val apiKey:String
): ArtistRemoteDatasource {
  override suspend fun getArtists()
    : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}
