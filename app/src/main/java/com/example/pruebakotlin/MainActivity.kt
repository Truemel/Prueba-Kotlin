package com.example.pruebakotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        val frag:HeroListFragment = HeroListFragment()
        changeFragment(frag)
    }

    fun changeFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.frame, fragment).commit()
    }
}