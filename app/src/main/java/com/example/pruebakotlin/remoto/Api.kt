package com.example.pruebakotlin.remoto

import com.example.pruebakotlin.pojo.Superheores
import retrofit2.Call
import retrofit2.http.*

interface  Api {

    @GET("all.json")
    fun getAllSuperheroes(): Call<List<Superheores>>

}