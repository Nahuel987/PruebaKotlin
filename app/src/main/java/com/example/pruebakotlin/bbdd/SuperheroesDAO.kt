package com.example.pruebakotlin.bbdd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebakotlin.pojo.Superheores

@Dao
interface SuperheroesDAO {

    //Insertar un listado de Superheroes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertaAllSuperheroes(listaSuperheroes: List<Superheores>)

    // Insertar 1 Superheroes
    @Insert
    suspend fun insertSuperheroes(superheores: Superheores)

    // Traer todos los elementos de la tabla
    @Query("SELECT * FROM tabla_superheroe ORDER BY id ASC")
    fun getllSuperheroes() : LiveData<List<Superheores>>

    //Borrar todos los Superheroes
    @Query("DELETE FROM tabla_superheroe")
    suspend fun deleteAllSuperheroes()

}