package com.example.pruebakotlin.modelo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.pruebakotlin.modelo.retrofit.HeroRetrofitRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroDBManager(private val heroDAO: HeroDAO, var context: Context) {

    suspend fun insertHeroList(list:MutableList<SuperheroCharacter>){
        heroDAO.insertHeroList(list)
    }

    suspend fun insertHero(hero: SuperheroCharacter){
        heroDAO.insertHero(hero)
    }

    suspend fun updateHero(hero:SuperheroCharacter){
        heroDAO.updateHero(hero)
    }

    fun getHeroList():LiveData<MutableList<SuperheroCharacter>>{
        return heroDAO.getHeroList()
    }

    fun updateAndSaveHeroListFromApiToDB(){
        HeroRetrofitRequest().getHeroListFromApi(object :Callback<MutableList<SuperheroCharacter>>{
            override fun onResponse(
                call: Call<MutableList<SuperheroCharacter>>,
                response: Response<MutableList<SuperheroCharacter>>
            ) {
                if(response.isSuccessful && response.body()!!.size > 0)
                    CoroutineScope(Dispatchers.IO).launch { insertHeroList(response.body()!!) }
            }

            override fun onFailure(call: Call<MutableList<SuperheroCharacter>>, t: Throwable) {
                Toast.makeText(context, "Error, no se pudo descargar la lista de heroes", Toast.LENGTH_LONG).show()
            }
        })
    }
}