package com.vila.kointest.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepositoryImpl : MainRepository {

    override suspend fun getData(): String {
        return withContext(Dispatchers.Default){
            delay(5000)
            "Hola Koin"
        }
    }
}