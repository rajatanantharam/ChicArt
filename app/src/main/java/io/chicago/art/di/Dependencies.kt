package io.chicago.art.di

import io.chicago.art.ChicagoArtApplication
import io.chicago.data.di.data
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object Dependencies {
    fun initialize(chicagoArtApplication: ChicagoArtApplication) {
        startKoin {
            androidContext(chicagoArtApplication)
            modules(app + data)
        }
    }
}