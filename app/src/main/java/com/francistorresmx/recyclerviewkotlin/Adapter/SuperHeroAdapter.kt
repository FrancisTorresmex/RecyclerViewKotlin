package com.francistorresmx.recyclerviewkotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.francistorresmx.recyclerviewkotlin.R
import com.francistorresmx.recyclerviewkotlin.SuperHero

class SuperHeroAdapter(private val superHeroLst: List<SuperHero>, private val onClickListener:(SuperHero) -> Unit): RecyclerView.Adapter<SuperHeroViewHolder>() {

    //Devuelve al ViewHolder los atributos dibujados
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate( R.layout.item_superhero, parent, false ))
    }

    //pasa por cada objeto
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        var item = superHeroLst[position]
        holder.render(item, onClickListener)
    }

    //Cantidad de elementos
    override fun getItemCount(): Int {
        return superHeroLst.size
    }


}