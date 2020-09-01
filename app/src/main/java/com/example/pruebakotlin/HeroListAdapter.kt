package com.example.pruebakotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.modelo.SuperheroCharacter
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.hero_list_adapter_layout.view.*

class HeroListAdapter(var list:MutableList<SuperheroCharacter>, var context: Context):RecyclerView.Adapter<HeroListAdapter.Holder>(),
    View.OnClickListener {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var name:TextView
        lateinit var image:ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.hero_list_adapter_layout, parent, false)
        val holder:Holder = Holder(view)
        holder.name = view.name
        holder.image = view.image

        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = list[position].name.toString()
        Picasso.get().load(list[position].images.md).into(holder.image)
        holder.image.tag = list[position]
        holder.image.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: MutableList<SuperheroCharacter>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            val frag:HeroDetailsFragment = HeroDetailsFragment()
            frag.arguments!!.putString("hero", Gson().toJson(v.tag as SuperheroCharacter))
            (context as MainActivity).changeFragment(frag)
        }
    }
}