package com.example.pruebakotlin.modelo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_table")
data class SuperheroCharacter (@PrimaryKey (autoGenerate = true) @NonNull val id:Int = 0, var name:String, var slug:String, var images:HeroImage){
    data class HeroImage(val xs:String, val sm:String, val md:String, val lg:String)
}