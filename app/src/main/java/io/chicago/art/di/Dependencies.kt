package io.chicago.art.di

import com.google.gson.Gson
import io.chicago.art.ChicagoArtApplication
import io.chicago.art.webservice.WebService
import io.chicago.art.webservice.baseUrl
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Dependencies {

    fun initialize(chicagoArtApplication: ChicagoArtApplication) {
        val appModule = module {
            single { Gson() }
            single { provideOkHttpClient() }
            single { provideRetrofit(get(), get()) }
            single { provideAPIService(get()) }
        }
        startKoin {
            androidLogger()
            androidContext(chicagoArtApplication)
            modules(appModule)
        }
    }

    private fun provideAPIService(retrofit: Retrofit): WebService =
        retrofit.create(WebService::class.java)

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