package com.example.pruebakotlin.modelo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HeroDAO {
    @Insert
    suspend fun insertHeroList(list:MutableList<SuperheroCharacter>)

    @Insert
    suspend fun insertHero(hero:SuperheroCharacter)

    @Update
    suspend fun updateHero(hero: SuperheroCharacter)

    @Query("SELECT * FROM hero_table")
    fun getHeroList():LiveData<MutableList<SuperheroCharacter>>
}