package io.chicago.domain.usecases

import io.chicago.domain.common.DefaultViewState
import io.chicago.domain.entities.ArtWorks

interface GetArtWorkUseCase {
    suspend operator fun invoke(): DefaultViewState<ArtWorks>
}