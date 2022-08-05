package com.vila.kointest.di

import android.app.Application
import com.vila.kointest.ui.MainViewModel
import com.vila.kointest.ui.MandroidViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmModelModule = module {
    // con viewmodel le decimos a koin como injectar un viewmodel
    // ya sa un viewmodel vacio o con argumentos donde koin genera un viewmodelfactory
    // y agrega las dependencias o el contexto como se ve en los ejemplos de abajo

    viewModel {MainViewModel(get())}

    viewModel{MandroidViewModel(androidContext() as Application)}

    
}
