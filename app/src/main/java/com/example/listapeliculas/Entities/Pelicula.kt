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
            Pelicula("https://pics.filmaffinity.com/kung_fu_panda-200447264-large.jpg","Kung Fu Panda", 2008, 95, "Animación| Comedia| Acción"),
            Pelicula("https://pics.filmaffinity.com/kung_fu_panda_2-863602215-large.jpg","Kung Fu Panda 2", 2011, 90, "Animación| Comedia| Acción"),
            Pelicula("https://pics.filmaffinity.com/kung_fu_panda_3-119198470-large.jpg","Kung Fu Panda 3", 2016, 95, "Animación| Comedia| Acción"),
            Pelicula("https://pics.filmaffinity.com/kung_fu_panda_4-159494298-large.jpg","Kung Fu Panda 4", 2024, 94, "Animación| Comedia| Acción"),
        )

        val dataEmpty = mutableListOf<Pelicula>()
}


}