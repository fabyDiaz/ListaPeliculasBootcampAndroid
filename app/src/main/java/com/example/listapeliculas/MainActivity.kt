package com.example.listapeliculas

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapeliculas.Entities.Pelicula
import com.example.listapeliculas.adapters.PeliculaAdpater
import com.example.listapeliculas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerPelicula.layoutManager = LinearLayoutManager(this)

        initAdapter()

    }

    fun initAdapter(){
        val peliculaAdapter = PeliculaAdpater()
        binding.recyclerPelicula.adapter = peliculaAdapter
        //peliculaAdapter.peliculas = Pelicula.dataPelicula

       /* sismoAdapter.onItemClickListener = {sismo ->
            //Toast.makeText(this,sismo.lugar, Toast.LENGTH_SHORT).show()
            enviarCorreoElectronicoSismo(sismo)
            enviarMensajeWhatsapp(sismo)
        }*/

        peliculaAdapter.peliculas = Pelicula.dataEmpty
        if(peliculaAdapter.peliculas.isEmpty())
            binding.empty.visibility = View.VISIBLE
        else
            binding.empty.visibility = View.GONE
    }
}