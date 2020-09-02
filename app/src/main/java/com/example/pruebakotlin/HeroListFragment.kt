package com.example.pruebakotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.viewmodel.HeroViewModel
import kotlinx.android.synthetic.main.hero_list_fragment_layout.view.*

class HeroListFragment() : Fragment() {

    lateinit var viewModel:HeroViewModel
    lateinit var listView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HeroViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.hero_list_fragment_layout, container, false)
        listView = view.recyclerV
        listView.layoutManager = LinearLayoutManager(context)
        listView.adapter = HeroListAdapter(mutableListOf(), context as MainActivity)
        viewModel.getHeroList().observe(context as MainActivity, Observer { (listView.adapter as HeroListAdapter).updateList(it) })

        return view
    }
}