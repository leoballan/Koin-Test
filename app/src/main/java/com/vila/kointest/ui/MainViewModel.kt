package com.vila.kointest.ui

import androidx.lifecycle.*
import com.vila.kointest.data.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository):ViewModel() {

    private val _data = MutableLiveData<String>()
    val data : LiveData<String> = _data

    fun fetchData(){
        viewModelScope.launch{
            _data.value =  repository.getData()
        }
    }

    fun fetchDataBeterWay() =
        liveData<String>(viewModelScope.coroutineContext+Dispatchers.Main) {
            emit("loading")
            try {
                emit(repository.getData())
            }catch (e:Exception){
                emit("Error")
            }
        }

}