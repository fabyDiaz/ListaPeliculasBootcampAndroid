package com.example.listapeliculas.Entities


data class Pelicula (
    val urlImagen : String,
    val titulo : String,
    val anio : Int,
    val duracion : Int
){

    companion object{
        val dataPelicula = mutableListOf(
            Pelicula("https://pics.filmaffinity.com/shrek-903764423-mmed.jpg","Shrek 1", 2001, 87),
            Pelicula("https://pics.filmaffinity.com/shrek_2-288126730-large.jpg","Shrek 2", 2004, 93),
            Pelicula("https://pics.filmaffinity.com/shrek_the_third_shrek_3-958228990-large.jpg","Shrek 3", 2007, 92)
        )

        val dataEmpty = mutableListOf<Pelicula>()
}


}