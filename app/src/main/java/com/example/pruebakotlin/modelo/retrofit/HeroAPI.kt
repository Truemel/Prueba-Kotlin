package com.example.pruebakotlin.modelo.retrofit

import com.example.pruebakotlin.modelo.SuperheroCharacter
import retrofit2.Call
import retrofit2.http.GET

interface HeroAPI {
    @GET("all.json")
    fun getHeroList():Call<MutableList<SuperheroCharacter>>
}