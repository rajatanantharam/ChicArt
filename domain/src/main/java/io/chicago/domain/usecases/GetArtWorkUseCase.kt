package io.chicago.domain.usecases

import io.chicago.domain.repositories.ArtWorkRepository

class GetArtWorkUseCase(private val artWorkRepository: ArtWorkRepository) {
    suspend operator fun invoke() = artWorkRepository.fetchArtworks()
}