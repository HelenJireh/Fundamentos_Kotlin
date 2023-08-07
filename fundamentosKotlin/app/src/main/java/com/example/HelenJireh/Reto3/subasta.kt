package com.example.HelenJireh.Reto3

class subasta {
}

fun main() {
    val articulosSubasta = listOf(
        "Cuadro",
        "Reloj",
        "Libro antiguo"
    )

    val precioBase = 1000
    val casaSubastas = "Casa de Subastas A"
    val ofertas = mutableMapOf<String, Int>()

    println("Bienvenido a la subasta en la $casaSubastas!")
    println("Los artículos en subasta son: ${articulosSubasta.joinToString(", ")}")

    for (articulo in articulosSubasta) {
        println("\n== Subasta de $articulo ==")
        println("Precio base: $precioBase")

        print("Ingresa tu oferta para $articulo (o presiona Enter para no ofertar): ")
        val ofertaStr = readLine() ?: ""
        if (ofertaStr.isNotEmpty()) {
            val oferta = ofertaStr.toIntOrNull()
            if (oferta != null && oferta > precioBase) {
                ofertas[articulo] = oferta
                println("Oferta aceptada.")
            } else {
                println("Oferta inválida o insuficiente.")
            }
        }
    }

    println("\n=== Resultados de la subasta ===")
    for (articulo in articulosSubasta) {
        val oferta = ofertas[articulo]
        if (oferta != null) {
            println("$articulo fue vendido por $casaSubastas a ${oferta} USD")
        } else {
            println("$articulo no recibió ofertas y fue vendido a $casaSubastas por $precioBase USD")
        }
    }
}
