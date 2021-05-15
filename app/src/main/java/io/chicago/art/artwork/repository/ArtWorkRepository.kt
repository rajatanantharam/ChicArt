package io.chicago.art.artwork.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.chicago.art.artwork.dto.api.ArtWorks
import io.chicago.art.viewstate.DefaultViewState
import io.chicago.art.webservice.WebService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface ArtWorkRepository {
    val cache: LiveData<DefaultViewState<ArtWorks>>
    suspend fun fetchArtworks()
}

class ArtWorkRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher,
    private val webService: WebService
): ArtWorkRepository {

    private val mutableCache: MutableLiveData<DefaultViewState<ArtWorks>> = MutableLiveData()
    override val cache: LiveData<DefaultViewState<ArtWorks>> = mutableCache

    override suspend fun fetchArtworks() {
        mutableCache.value = DefaultViewState.Loading()
        try {
            mutableCache.value = withContext(ioDispatcher) {
                DefaultViewState.Success(webService.getArtworks())
            }
        } catch (ex: Exception) {
            ex.message?.let {
                mutableCache.value = DefaultViewState.Error()
            }
        }
    }
}