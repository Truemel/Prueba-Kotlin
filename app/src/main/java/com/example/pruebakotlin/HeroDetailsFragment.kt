package com.example.pruebakotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pruebakotlin.modelo.SuperheroCharacter
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.hero_details_fragment_layout.view.*

class HeroDetailsFragment():Fragment(), View.OnClickListener {

    lateinit var hero:SuperheroCharacter
    lateinit var goBack:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hero = Gson().fromJson(arguments!!.get("hero").toString(), SuperheroCharacter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.hero_details_fragment_layout, container, false)
        view.detName.text = hero.name.toString()
        Picasso.get().load(hero.images.lg).into(view.detImage)
        view.detSlug.text = hero.slug
        goBack = view.detButton
        goBack.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        (context as MainActivity).changeFragment(HeroListFragment())
    }

}