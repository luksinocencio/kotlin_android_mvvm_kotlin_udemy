package com.devmeist3r.tmdbclient.domain.repository

import com.devmeist3r.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}
