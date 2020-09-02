package com.example.pruebakotlin.vistamodelo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pruebakotlin.modelo.SuperheoresRepositorio
import com.example.pruebakotlin.pojo.Superheores

class SuperheroeViewModel (application : Application): AndroidViewModel(application) {


    private val repository =  SuperheoresRepositorio(application)
    private val superList = repository.pasarLiveDataToViewModel()

    fun fetchFromServer() {
        repository.fetchDataFromServer()
    }

    fun getDataFromDB(): LiveData<List<Superheores>> {
        return superList
    }





}