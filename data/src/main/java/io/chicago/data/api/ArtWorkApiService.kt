package io.chicago.data.api

import io.chicago.domain.entities.ArtWorks
import retrofit2.http.GET
import retrofit2.http.Query

const val baseUrl = "https://api.artic.edu/api/v1/"

interface ArtWorkApiService {
    @GET("artworks")
    suspend fun getArtworks(@Query("limit") limit: Int = 25): ArtWorks
}