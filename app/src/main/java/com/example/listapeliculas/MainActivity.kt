package com.example.listapeliculas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapeliculas.Entities.Pelicula
import com.example.listapeliculas.adapters.PeliculaAdpater
import com.example.listapeliculas.databinding.ActivityMainBinding
import java.io.File
import java.net.URLEncoder

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
        peliculaAdapter.peliculas = Pelicula.dataPelicula

       peliculaAdapter.onItemClickListener = {pelicula ->
            Toast.makeText(this,"Esto es una pelicula", Toast.LENGTH_SHORT).show()
            enviarCorreoElectronicoPelicula(pelicula)
            enviarMensajeWhatsapp(pelicula)
        }

        //peliculaAdapter.peliculas = Pelicula.dataEmpty
        if(peliculaAdapter.peliculas.isEmpty())
            binding.empty.visibility = View.VISIBLE
        else
            binding.empty.visibility = View.GONE
    }


    private fun enviarCorreoElectronicoPelicula(pelicula: Pelicula){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("fabiola.dinar@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Envío información de película")
        intent.putExtra(Intent.EXTRA_TEXT, "Título: ${pelicula.titulo}\nAño: ${pelicula.anio}\nDuración: ${pelicula.duracion}\nGénero: ${pelicula.genero}")

        // Obtener la URI de la imagen
        val uri = Uri.parse(pelicula.URLimagen)
        // Adjuntar la imagen al intent
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Enviar correo películas"))
        } else {
            Toast.makeText(this, "Debes tener una aplicación de correo electrónico", Toast.LENGTH_SHORT).show()
        }
    }

    fun enviarMensajeWhatsapp(pelicula: Pelicula){

       // val telefonoWsp = "+5492616101861"
        val mensaje = "*Título:* ${pelicula.titulo}\n" +
                "*Año:* ${pelicula.anio}\n" +
                "*Duración:* ${pelicula.duracion} min\n" +
                "*Género:* ${pelicula.genero}\n" +
                "*URL de la imagen:* ${pelicula.URLimagen}"
        val mensajeCodificado = URLEncoder.encode(mensaje, "UTF-8")
        val uri = Uri.parse("https://api.whatsapp.com/send?&text=$mensajeCodificado")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Enviar Película"))
        } else {
            Toast.makeText(this, "Debes tener WhatsApp instalado", Toast.LENGTH_SHORT).show()
        }
    }


}