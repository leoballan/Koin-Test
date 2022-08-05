package com.vila.kointest.di

import com.vila.kointest.data.MainRepository
import com.vila.kointest.data.MainRepositoryImpl
import com.vila.kointest.model.Orco
import com.vila.kointest.model.Warrior
import com.vila.kointest.ui.MainActivity
import org.koin.dsl.module

val repoModule = module {

    scope<MainActivity>{
        scoped{ Orco() }
    }
    single<MainRepository>{return@single MainRepositoryImpl()}

    factory {  Warrior()  }


}