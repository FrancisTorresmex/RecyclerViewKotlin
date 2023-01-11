package com.francistorresmx.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.francistorresmx.recyclerviewkotlin.Adapter.SuperHeroAdapter
import com.francistorresmx.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //esto remplaza tener que iniciar todos con: val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        initRecyclerView()
    }


    //Ejemplo Linear Layout
    private fun initRecyclerView() {
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)

        val manager = LinearLayoutManager(this)

        //decoración (linea divisora por item)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerSuperHero.layoutManager = manager
        binding.recyclerSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList) {
            onItemSelected(it)
        }
        binding.recyclerSuperHero.addItemDecoration(decoration) //agregar decoración
    }


    //Ejemplo Guird Layout
//    private fun initRecyclerView() {
//
//        val manager = GridLayoutManager(this, 2) //numero de columnas
//
//        //decoración (linea divisora por item)
//        val decoration = DividerItemDecoration(this, manager.orientation)
//
//        binding.recyclerSuperHero.layoutManager = manager
//        binding.recyclerSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList) {
//            onItemSelected(it)
//        }
//        binding.recyclerSuperHero.addItemDecoration(decoration) //agregar decoración
//    }


    //funcion que se encarga de lo que pasa al precionar el item
    fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.superHero, Toast.LENGTH_SHORT).show()
    }
}