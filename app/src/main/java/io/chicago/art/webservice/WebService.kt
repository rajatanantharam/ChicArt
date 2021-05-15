package io.chicago.art.webservice

import io.chicago.art.collection.dto.api.ArtWorks
import retrofit2.http.GET
import retrofit2.http.Query

const val baseUrl = "https://api.artic.edu/api/v1"

interface WebService {

    @GET("/artworks")
    suspend fun getArtworks(@Query("limit") limit: Int = 25): ArtWorks
}