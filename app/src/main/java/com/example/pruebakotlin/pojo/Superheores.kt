package com.example.pruebakotlin.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_superheroe")
data class Superheores (@PrimaryKey val id:Int, val name:String, val slug:String){

}

