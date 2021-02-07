package com.devmeist3r.tmdbclient.data.repository.artist.datasource

import com.devmeist3r.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
  suspend fun getArtists(): Response<ArtistList>
}
