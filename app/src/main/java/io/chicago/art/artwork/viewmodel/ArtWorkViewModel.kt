package io.chicago.art.artwork.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.chicago.art.artwork.repository.ArtWorkRepository
import kotlinx.coroutines.launch

class ArtWorkViewModel(private val artWorkRepository: ArtWorkRepository) : ViewModel() {
    val viewState = artWorkRepository.cache

    fun fetchArtworks() {
        viewModelScope.launch {
            artWorkRepository.fetchArtworks()
        }
    }
}