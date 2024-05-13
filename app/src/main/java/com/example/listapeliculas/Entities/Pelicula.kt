package com.example.listapeliculas.Entities


data class Pelicula (
    val URLimagen : String,
    val titulo : String,
    val anio : Int,
    val duracion : Int,
    val genero: String
){

    companion object{
        val dataPelicula = mutableListOf(
            Pelicula("https://pics.filmaffinity.com/shrek-903764423-large.jpg","Shrek 1", 2001, 87, "Animación| Comedia| Fantástico| Aventuras"),
            Pelicula("https://pics.filmaffinity.com/shrek_2-288126730-large.jpg","Shrek 2", 2004, 93, "Animación| Comedia| Fantástico| Aventuras"),
            Pelicula("https://pics.filmaffinity.com/shrek_the_third_shrek_3-958228990-large.jpg","Shrek 3", 2007, 92, "Animación| Comedia| Fantástico| Aventuras"),
            Pelicula("https://pics.filmaffinity.com/shrek_forever_after_shrek_4-573083189-large.jpg","Shrek, felices para siempre (Shrek 4)", 2010, 93, "Animación| Comedia| Fantástico| Aventuras"),
            Pelicula("https://pics.filmaffinity.com/puss_in_boots-288874915-large.jpg","El gato con botas", 2011, 82, "Animación| Comedia| Fantástico| Aventuras"),
            Pelicula("https://pics.filmaffinity.com/puss_in_boots_the_last_wish-897078202-large.jpg","El gato con botas: El último deseo", 2022, 100, "Animación| Comedia| Fantástico| Aventuras"),
        )

        val dataEmpty = mutableListOf<Pelicula>()
}


}