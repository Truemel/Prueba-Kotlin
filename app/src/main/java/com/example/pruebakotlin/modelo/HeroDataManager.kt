package com.example.pruebakotlin.modelo

import android.content.Context

class HeroDataManager(context: Context) {

    private var dbManager:HeroDBManager

    init {
        dbManager = HeroDBManager(HeroDB.getDB(context).getHeroDAO())
    }

}