package com.example.pruebakotlin.bbdd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pruebakotlin.pojo.Superheores

@Database(entities = [Superheores::class], version = 1,exportSchema = false)
abstract class SuperheroesRoomDatabase : RoomDatabase() {

    abstract fun superheroesDao() : SuperheroesDAO

    companion object {
        @Volatile
        private var INSTANCE: SuperheroesRoomDatabase? = null

        fun getDatabase(context: Context): SuperheroesRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperheroesRoomDatabase::class.java,
                    "post_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }




}