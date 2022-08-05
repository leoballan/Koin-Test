package com.vila.kointest.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.vila.kointest.R
import org.koin.dsl.koinApplication

class MandroidViewModel (val application: Application): ViewModel()
{
    fun test(){
        val cadena = application.getString(R.string.app_name)
        Log.d("mControl"," el nombre de la app es $cadena")
    }
}