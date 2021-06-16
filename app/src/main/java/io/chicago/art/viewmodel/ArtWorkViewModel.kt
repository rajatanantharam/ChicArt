package io.chicago.art.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.chicago.domain.common.DefaultViewState
import io.chicago.domain.usecases.GetArtWorkUseCase

class ArtWorkViewModel(private val getArtWorkUseCase: GetArtWorkUseCase) : ViewModel() {
    val artWorks: LiveData<DefaultViewState> = liveData {
        emit(DefaultViewState.Loading)
        try {
            emit(getArtWorkUseCase.invoke())
        } catch (e: Exception) {
            emit(DefaultViewState.Error(e.localizedMessage))
        }
    }
}