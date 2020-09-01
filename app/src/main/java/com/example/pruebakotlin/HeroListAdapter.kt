package com.example.pruebakotlin

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.modelo.SuperheroCharacter

class HeroListAdapter(var list:MutableList<SuperheroCharacter>):RecyclerView.Adapter<HeroListAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: MutableList<SuperheroCharacter>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}