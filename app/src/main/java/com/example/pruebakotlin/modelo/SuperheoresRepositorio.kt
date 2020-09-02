package com.example.pruebakotlin.modelo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.pruebakotlin.bbdd.SuperheroesRoomDatabase
import com.example.pruebakotlin.pojo.Superheores
import com.example.pruebakotlin.remoto.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperheoresRepositorio (context: Context) {

    private val tag = "SuperheroesRepositorio"

    //esto viene  de la Base de datos
    private val db: SuperheroesRoomDatabase = SuperheroesRoomDatabase.getDatabase(context)
    private val listaSuperheroes = db.superheroesDao(). getllSuperheroes()


    fun pasarLiveDataToViewModel() : LiveData<List<Superheores>> {
        return listaSuperheroes
    }

    // esto hace la llamada a retrofit
    fun fetchDataFromServer() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getAllSuperheroes()

        call.enqueue(object : Callback<List<Superheores>> {
            override fun onResponse(call: Call<List<Superheores>>, response: Response<List<Superheores>>) {
                //Log.e( "ERRR",response.body().toString())

                Log.d(tag, response.body().toString())
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let { db.superheroesDao().insertaAllSuperheroes(it) }
                }
            }
            override fun onFailure(call: Call<List<Superheores>>, t: Throwable) {
                Log.d(tag, t.message.toString())
            }
        })

    }


}