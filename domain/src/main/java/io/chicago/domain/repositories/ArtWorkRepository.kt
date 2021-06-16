package io.chicago.domain.repositories

import io.chicago.domain.common.DefaultViewState
import io.chicago.domain.entities.ArtWorks

interface ArtWorkRepository {
    suspend fun fetchArtworks() : DefaultViewState<ArtWorks>
}