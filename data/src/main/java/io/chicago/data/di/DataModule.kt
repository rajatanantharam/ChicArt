package io.chicago.data.di

import com.google.gson.Gson
import io.chicago.data.api.ArtWorkApiService
import io.chicago.data.api.baseUrl
import io.chicago.data.domainImplementations.repositories.ArtWorkRepositoryImpl
import io.chicago.data.domainImplementations.usecases.GetArtWorkUseCaseImpl
import io.chicago.domain.repositories.ArtWorkRepository
import io.chicago.domain.usecases.GetArtWorkUseCase
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val data = module {
    single { Gson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
    single { provideApi() }
    factory<ArtWorkRepository> { ArtWorkRepositoryImpl(get()) }
    factory<GetArtWorkUseCase> { GetArtWorkUseCaseImpl(get()) }
}

private fun provideApi(): ArtWorkApiService {
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