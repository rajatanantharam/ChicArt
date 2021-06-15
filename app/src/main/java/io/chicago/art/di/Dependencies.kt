package io.chicago.art.di

import io.chicago.art.ChicagoArtApplication
import io.chicago.art.viewmodel.ArtWorkViewModel
import io.chicago.data.api.NetworkModule
import io.chicago.data.repositories.ArtWorkRepositoryImpl
import io.chicago.domain.repositories.ArtWorkRepository
import io.chicago.domain.usecases.GetArtWorkUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object Dependencies {

    fun initialize(chicagoArtApplication: ChicagoArtApplication) {
        val appModule = module {
            single { NetworkModule.createArtWorkApi() }
            single { ArtWorkRepositoryImpl(get()) as ArtWorkRepository }
            single { GetArtWorkUseCase(get()) }
            viewModel { ArtWorkViewModel(get()) }

        }
        startKoin {
            androidContext(chicagoArtApplication)
            modules(appModule)
        }
    }
}