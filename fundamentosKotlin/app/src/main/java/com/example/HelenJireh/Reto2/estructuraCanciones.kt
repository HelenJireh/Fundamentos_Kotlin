package com.example.HelenJireh.Reto2

class estructuraCanciones {
}

fun main() {
    println("Bienvenido al programa de gestión de álbumes de canciones.")

    print("¿Cuántas canciones tiene este álbum? ")
    val numCanciones = readLine()?.toIntOrNull() ?: 0

    if (numCanciones <= 0) {
        println("El álbum debe tener al menos una canción.")
        return
    }

    print("Tipo de música del álbum: ")
    val tipoMusica = readLine() ?: ""

    val canciones = mutableListOf<Map<String, Any>>()

    for (i in 1..numCanciones) {
        println("\n=== Canción $i ===")
        print("Título: ")
        val titulo = readLine() ?: ""
        print("Artista: ")
        val artista = readLine() ?: ""
        print("Año de publicación: ")
        val anioPublicacion = readLine()?.toIntOrNull() ?: 0
        print("Recuento de reproducciones: ")
        val reproducciones = readLine()?.toIntOrNull() ?: 0

        val cancion = mapOf(
            "titulo" to titulo,
            "artista" to artista,
            "anioPublicacion" to anioPublicacion,
            "reproducciones" to reproducciones
        )
        canciones.add(cancion)
    }

    var cancionMasPopular = ""
    var reproduccionesMasPopulares = 0

    println("\n=== Resumen del álbum ===")
    for (cancion in canciones) {
        val titulo = cancion["titulo"]
        val artista = cancion["artista"]
        val anioPublicacion = cancion["anioPublicacion"]
        val reproducciones = cancion["reproducciones"]

        println("$titulo, interpretada por $artista, se lanzó en $anioPublicacion, $reproducciones reproducciones.")

        if (reproducciones is Int && reproducciones > reproduccionesMasPopulares) {
            cancionMasPopular = titulo.toString()
            reproduccionesMasPopulares = reproducciones
        }
    }

    println("\nCanción más popular: $cancionMasPopular, con $reproduccionesMasPopulares reproducciones.")
    println("\n=== Evaluación de popularidad ===")
    for (cancion in canciones) {
        val titulo = cancion["titulo"]
        val reproducciones = cancion["reproducciones"] as? Int ?: 0

        val popularidad = if (reproducciones < 1000) "poco popular" else "popular"
        println("$titulo es $popularidad.")
    }
}
