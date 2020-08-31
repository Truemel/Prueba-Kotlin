package com.example.pruebakotlin.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperheroCharacter::class], version = 1, exportSchema = false)
abstract class HeroDB: RoomDatabase() {
    abstract fun getHeroDAO():HeroDAO

    companion object{
        private var db:HeroDB? = null
        private const val DB_NAME = "Hero_DB"

        fun getDB(context: Context):HeroDB{
            if(db == null)
                synchronized(this) {
                    db = Room.databaseBuilder(context, HeroDB::class.java, DB_NAME).build()
                }
            return db!!
        }
    }
}