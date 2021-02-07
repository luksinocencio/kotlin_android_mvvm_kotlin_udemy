package com.devmeist3r.tmdbclient.domain.usecase

import com.devmeist3r.tmdbclient.data.model.artist.Artist
import com.devmeist3r.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}
