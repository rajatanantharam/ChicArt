package io.chicago.data.domainImplementations.repositories

import io.chicago.data.api.ArtWorkApiService
import io.chicago.domain.common.DefaultViewState
import io.chicago.domain.entities.ArtWorks
import io.chicago.domain.repositories.ArtWorkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtWorkRepositoryImpl(private val artWorkApiService: ArtWorkApiService): ArtWorkRepository {
    override suspend fun fetchArtworks(): DefaultViewState<ArtWorks> =
        withContext(Dispatchers.IO) {
            try {
                DefaultViewState.Success(artWorkApiService.getArtworks())
            } catch (e: Exception) {
                DefaultViewState.Error()
            }
        }
}