package io.chicago.domain.repositories

import io.chicago.domain.common.DefaultViewState

interface ArtWorkRepository {
    suspend fun fetchArtworks() : DefaultViewState
}