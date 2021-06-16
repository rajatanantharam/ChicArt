package io.chicago.art.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.chicago.domain.common.DefaultViewState
import io.chicago.domain.entities.ArtWorks
import io.chicago.domain.usecases.GetArtWorkUseCase
import kotlinx.coroutines.launch

class ArtWorkViewModel(private val getArtWorkUseCase: GetArtWorkUseCase) : ViewModel() {
    val mutableViewState: MutableLiveData<DefaultViewState<ArtWorks>> = MutableLiveData()

    fun fetchArtworks() {
        mutableViewState.value = DefaultViewState.Loading()
        viewModelScope.launch {
            mutableViewState.value = getArtWorkUseCase.invoke()
        }
    }
}