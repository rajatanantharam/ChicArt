package io.chicago.domain.common

import io.chicago.domain.entities.ArtWorks

sealed class DefaultViewState {

    object Loading : DefaultViewState()

    class Error(val reason: String?) : DefaultViewState()

    class Success(val result: ArtWorks) : DefaultViewState()
}