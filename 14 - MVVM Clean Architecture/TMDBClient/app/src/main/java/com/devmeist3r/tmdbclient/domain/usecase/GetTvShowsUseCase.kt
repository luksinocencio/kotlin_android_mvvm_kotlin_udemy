package com.devmeist3r.tmdbclient.domain.usecase

import com.devmeist3r.tmdbclient.data.model.tvshow.TvShow
import com.devmeist3r.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}
