package com.francistorresmx.recyclerviewkotlin.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.francistorresmx.recyclerviewkotlin.R
import com.francistorresmx.recyclerviewkotlin.SuperHero
import com.francistorresmx.recyclerviewkotlin.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)

    /*val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val realName = view.findViewById<TextView>(R.id.tvRealName)
    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)*/

    fun render(superHeroModel: SuperHero, onClickListener:(SuperHero) -> Unit) {
        binding.tvSuperHeroName.text = superHeroModel.superHero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)

        //click en imagen
        binding.ivSuperHero.setOnClickListener {
            onClickListener(superHeroModel)
        }

        //click en toda la celda (itemView es toda la celda)
        itemView.setOnClickListener {
            onClickListener(superHeroModel)
        }
    }

}