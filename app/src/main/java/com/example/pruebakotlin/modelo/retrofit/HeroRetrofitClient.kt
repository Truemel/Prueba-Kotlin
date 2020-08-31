package com.example.pruebakotlin.modelo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroRetrofitClient {

    companion object{
        private const val PATH:String = "https://akabab.github.io/superhero-api/api/"
        private var retro:Retrofit? = null

        fun getRetro():Retrofit{
            if(retro == null)
                synchronized(this){
                    retro = Retrofit.Builder().baseUrl(PATH).addConverterFactory(GsonConverterFactory.create()).build()
                }
            return retro!!
        }
    }
}