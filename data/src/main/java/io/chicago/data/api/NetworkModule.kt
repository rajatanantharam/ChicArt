package io.chicago.data.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    fun createArtWorkApi(): ArtWorkApiService {
        val retrofit = provideRetrofit(provideOkHttpClient(), Gson())
        return retrofit.create(ArtWorkApiService::class.java)
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    private fun provideOkHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)

        clientBuilder.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .method(original.method(), original.body())
            chain.proceed(requestBuilder.build())
        }.build()
        return clientBuilder.build()
    }
}