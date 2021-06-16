package io.chicago.data.domainImplementations.usecases

import io.chicago.domain.repositories.ArtWorkRepository
import io.chicago.domain.usecases.GetArtWorkUseCase

class GetArtWorkUseCaseImpl(private val artWorkRepository: ArtWorkRepository) : GetArtWorkUseCase {
    override suspend operator fun invoke() = artWorkRepository.fetchArtworks()
}