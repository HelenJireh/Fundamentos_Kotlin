package com.example.HelenJireh.reto4

class menuRestaurante {
}
fun main() {
    val menu = mutableMapOf<String, MutableList<Map<String, Any>>>()

    while (true) {
        println("\n==== MENÚ DEL RESTAURANTE ====")
        println("1. Agregar plato")
        println("2. Mostrar todos los platos")
        println("3. Mostrar platos por categoría")
        println("4. Modificar menú")
        println("5. Modificar plato")
        println("6. Eliminar plato")
        println("0. Salir")

        print("Seleccione una opción: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\n==== AGREGAR PLATO ====")
                print("Categoría (Entradas/Platos Fuertes/Postres/Bebidas): ")
                val categoria = readLine()?.capitalize() ?: ""
                print("Nombre del plato: ")
                val nombre = readLine() ?: ""
                print("Descripción del plato: ")
                val descripcion = readLine() ?: ""
                print("Precio del plato: ")
                val precio = readLine()?.toDoubleOrNull() ?: 0.0

                val plato = mapOf("nombre" to nombre, "descripcion" to descripcion, "precio" to precio)

                menu.getOrPut(categoria) { mutableListOf() }.add(plato)
                println("Plato agregado al menú.")
            }
            2 -> {
                println("\n==== MOSTRAR TODOS LOS PLATOS ====")
                for ((categoria, platos) in menu) {
                    println("\nCategoría: $categoria")
                    for ((index, plato) in platos.withIndex()) {
                        println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} ($${plato["precio"]})")
                    }
                }
            }
            3 -> {
                println("\n==== MOSTRAR PLATOS POR CATEGORÍA ====")
                print("Ingrese la categoría (Entradas/Platos Fuertes/Postres/Bebidas): ")
                val categoria = readLine()?.capitalize() ?: ""

                val platos = menu[categoria]
                if (platos != null) {
                    println("\nPlatos en la categoría '$categoria':")
                    for ((index, plato) in platos.withIndex()) {
                        println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} ($${plato["precio"]})")
                    }
                } else {
                    println("Categoría no encontrada.")
                }
            }
            4 -> {
                println("\n==== MODIFICAR MENÚ ====")
                print("Ingrese la categoría a modificar (Entradas/Platos Fuertes/Postres/Bebidas): ")
                val categoria = readLine()?.capitalize() ?: ""

                val platos = menu[categoria]
                if (platos != null) {
                    println("Categoría actual: $categoria")
                    print("Ingrese la nueva categoría: ")
                    val nuevaCategoria = readLine()?.capitalize() ?: ""

                    if (menu.containsKey(nuevaCategoria)) {
                        println("La nueva categoría ya existe en el menú.")
                    } else {
                        menu[nuevaCategoria] = platos
                        menu.remove(categoria)
                        println("Categoría modificada exitosamente.")
                    }
                } else {
                    println("Categoría no encontrada.")
                }
            }
            5 -> {
                println("\n==== MODIFICAR PLATO ====")
                print("Ingrese la categoría del plato a modificar (Entradas/Platos Fuertes/Postres/Bebidas): ")
                val categoria = readLine()?.capitalize() ?: ""

                val platos = menu[categoria]
                if (platos != null) {
                    println("Platos en la categoría '$categoria':")
                    for ((index, plato) in platos.withIndex()) {
                        println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} ($${plato["precio"]})")
                    }

                    print("Ingrese el número del plato a modificar: ")
                    val numeroPlato = readLine()?.toIntOrNull()?.minus(1) ?: -1

                    if (numeroPlato in 0 until platos.size) {
                        val plato = platos[numeroPlato]

                        println("Plato actual: ${plato["nombre"]} - ${plato["descripcion"]} ($${plato["precio"]})")
                        print("Nuevo nombre del plato: ")
                        val nuevoNombre = readLine() ?: plato["nombre"]
                        print("Nueva descripción del plato: ")
                        val nuevaDescripcion = readLine() ?: plato["descripcion"]
                        print("Nuevo precio del plato: ")
                        val nuevoPrecio = readLine()?.toDoubleOrNull() ?: plato["precio"]

                        platos[numeroPlato] = mapOf("nombre" to nuevoNombre, "descripcion" to nuevaDescripcion, "precio" to nuevoPrecio)
                        println("Plato modificado exitosamente.")
                    } else {
                        println("Número de plato inválido.")
                    }
                } else {
                    println("Categoría no encontrada.")
                }
            }
            6 -> {
                println("\n==== ELIMINAR PLATO ====")
                print("Ingrese la categoría del plato a eliminar (Entradas/Platos Fuertes/Postres/Bebidas): ")
                val categoria = readLine()?.capitalize() ?: ""

                val platos = menu[categoria]
                if (platos != null) {
                    println("Platos en la categoría '$categoria':")
                    for ((index, plato) in platos.withIndex()) {
                        println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} ($${plato["precio"]})")
                    }

                    print("Ingrese el número del plato a eliminar: ")
                    val numeroPlato = readLine()?.toIntOrNull()?.minus(1) ?: -1

                    if (numeroPlato in 0 until platos.size) {
                        val plato = platos[numeroPlato]
                        println("Eliminando plato '${plato["nombre"]}'")
                        platos.removeAt(numeroPlato)
                        println("Plato eliminado exitosamente.")
                    } else {
                        println("Número de plato inválido.")
                    }
                } else {
                    println("Categoría no encontrada.")
                }
            }
            0 -> {
                println("Saliendo del programa.")
                return
            }
            else -> {
                println("Opción inválida.")
            }
        }
    }
}
