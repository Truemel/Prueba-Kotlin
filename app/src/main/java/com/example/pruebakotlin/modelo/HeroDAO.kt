package com.example.pruebakotlin.modelo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HeroDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroList(list:MutableList<SuperheroCharacter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(hero:SuperheroCharacter)

    @Update
    suspend fun updateHero(hero: SuperheroCharacter)

    @Query("SELECT * FROM hero_table")
    fun getHeroList():LiveData<MutableList<SuperheroCharacter>>
}