package io.chicago.art.di

import io.chicago.art.viewmodel.ArtWorkViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val app = module {
    viewModel { ArtWorkViewModel(get()) }
}