package com.vila.kointest.data

interface MainRepository {

    suspend fun getData() : String

}