package io.chicago.domain.usecases

import io.chicago.domain.common.DefaultViewState

interface GetArtWorkUseCase {
    suspend operator fun invoke(): DefaultViewState
}