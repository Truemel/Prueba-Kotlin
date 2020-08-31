package com.example.pruebakotlin.modelo.retrofit

import com.example.pruebakotlin.modelo.SuperheroCharacter
import retrofit2.Call
import retrofit2.Callback

class HeroRetrofitRequest{

    private var apiRequest: HeroAPI

            init {
                apiRequest = HeroRetrofitClient.getRetro().create(HeroAPI::class.java)
            }

    fun getHeroListFromApi(callB:Callback<MutableList<SuperheroCharacter>>){
        var call:Call<MutableList<SuperheroCharacter>> = apiRequest.getHeroList()
        call.enqueue(callB)
    }
}