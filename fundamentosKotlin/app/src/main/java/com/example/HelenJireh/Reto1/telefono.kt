package com.example.HelenJireh.Reto1

class telefono {
}

fun main() {

        val mensajesPorTelefono = mutableMapOf<String, Int>()

        while (true) {
            println("\n==== MENÚ ====")
            println("1. Agregar notificaciones a un teléfono")
            println("2. Mostrar resumen de notificaciones por teléfono")
            println("0. Salir")

            print("Elige una opción: ")
            when (readLine()?.toIntOrNull()) {
                1 -> {
                    print("Ingresa el número de teléfono: ")
                    val telefono = readLine() ?: continue

                    print("Ingresa la cantidad de notificaciones: ")
                    val cantidad = readLine()?.toIntOrNull() ?: continue

                    mensajesPorTelefono[telefono] = cantidad
                }
                2 -> {
                    if (mensajesPorTelefono.isEmpty()) {
                        println("No existen mensajes disponibles.")
                    } else {
                        println("\n==== RESUMEN DE NOTIFICACIONES POR TELÉFONO ====")
                        for ((telefono, cantidad) in mensajesPorTelefono) {
                            val mensaje = if (cantidad < 100) {
                                "$cantidad notificaciones"
                            } else {
                                "99+ notificaciones"
                            }
                            println("$telefono: $mensaje")
                        }
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

