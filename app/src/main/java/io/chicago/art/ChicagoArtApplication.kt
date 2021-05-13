package io.chicago.art

import android.app.Application
import io.chicago.art.di.Dependencies

class ChicagoArtApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Dependencies.initialize(this)
    }
}
