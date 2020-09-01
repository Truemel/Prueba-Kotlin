package com.example.pruebakotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pruebakotlin.modelo.HeroDBManager
import com.example.pruebakotlin.modelo.HeroDataManager
import com.example.pruebakotlin.modelo.SuperheroCharacter
import kotlinx.coroutines.launch

class HeroViewModel(application: Application) : AndroidViewModel(application) {

    private val heroDBManager:HeroDBManager
    private val heroList:LiveData<MutableList<SuperheroCharacter>>

    init {
        heroDBManager = HeroDataManager(application.baseContext).getHeroDBManager()
        heroList = heroDBManager.getHeroList()
    }

    fun insertHeroList(list: MutableList<SuperheroCharacter>) = viewModelScope.launch { heroDBManager.insertHeroList(list) }

    fun insertHero(hero:SuperheroCharacter) = viewModelScope.launch { heroDBManager.insertHero(hero) }

    fun updateHero(hero: SuperheroCharacter) = viewModelScope.launch { heroDBManager.updateHero(hero) }
}