package com.example.listapeliculas.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.listapeliculas.Entities.Pelicula
import com.example.listapeliculas.databinding.PeliculaItemBinding

private val TAG = PeliculaAdpater::class.java.simpleName

class PeliculaAdpater: RecyclerView.Adapter<PeliculaAdpater.PeliculaViewHolder>(){

    lateinit var onItemClickListener:(Pelicula)->Unit

    var peliculas = mutableListOf<Pelicula>()

        @SuppressLint("NotifyDataSetChanged")
        set(value){
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeliculaAdpater.PeliculaViewHolder {

        val bindingItem = PeliculaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeliculaViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: PeliculaAdpater.PeliculaViewHolder, position: Int) {
        val pelicula: Pelicula = peliculas[position]
        holder.bind(pelicula)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }




    inner class PeliculaViewHolder(private var bindingItem: PeliculaItemBinding)
        : RecyclerView.ViewHolder(bindingItem.root){

        val imagen =  bindingItem.ImgenPortada

            fun bind(pelicula: Pelicula){

                Glide.with(bindingItem.listaPeliculas)
                    .load(pelicula.URLimagen)
                    .into(imagen)

                with(pelicula){
                    bindingItem.tituloOriginal.text = pelicula.titulo
                    bindingItem.anioPelicula.text = pelicula.anio.toString()
                    bindingItem.duracionPelicula.text = pelicula.duracion.toString()
                    bindingItem.txtGenero.text = pelicula.genero
            }
            //Le da el click a todo, no solo a la flecha
            bindingItem.root.setOnClickListener{
                if(::onItemClickListener.isInitialized)
                    onItemClickListener(pelicula)
                else
                    Log.e(TAG, "Listener not initilizate")
            }

        }
    }




}