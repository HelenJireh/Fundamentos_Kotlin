package com.example.HelenJireh.Reto5

class nequi {
}
fun main() {
    val celular = "1234567890"
    val clave = "1234"
    var saldoDisponible = 4500

    println("¡Bienvenido a Nequi Colombia!")
    var intentos = 3

    while (intentos > 0) {
        print("Ingresa tu número de celular: ")
        val celularIngresado = readLine() ?: ""
        print("Ingresa tu clave de 4 dígitos: ")
        val claveIngresada = readLine() ?: ""

        if (celularIngresado == celular && claveIngresada == clave) {
            println("Acceso permitido.")
            break
        } else {
            println("¡Upps! Parece que tus datos de acceso no son correctos.")
            intentos--
            if (intentos > 0) {
                println("Tienes $intentos intentos más.")
            } else {
                println("No te quedan más intentos. Hasta luego.")
                return
            }
        }
    }

    println("Saldo disponible: $saldoDisponible")

    while (true) {
        println("\n== Funcionalidades ==")
        println("1. Saca")
        println("2. Envía")
        println("3. Recarga")
        println("4. Salir")

        print("Selecciona una opción: ")
        val opcion = readLine()?.toIntOrNull() ?: continue

        when (opcion) {
            1 -> {
                println("\n== Saca ==")
                println("1. Cajero")
                println("2. Punto físico")
                print("Selecciona una opción: ")
                val opcionSaca = readLine()?.toIntOrNull() ?: continue

                if (saldoDisponible < 2000) {
                    println("No te alcanza para hacer un retiro.")
                } else {
                    when (opcionSaca) {
                        1, 2 -> {
                            print("Confirmar retiro de: ")
                            val retiro = readLine()?.toIntOrNull() ?: continue
                            if (retiro <= saldoDisponible) {
                                println("Retiro exitoso. Código de retiro: ${generateCodigo()}")
                                saldoDisponible -= retiro
                            } else {
                                println("No tienes suficiente saldo para este retiro.")
                            }
                        }
                        else -> println("Opción inválida.")
                    }
                }
            }
            2 -> {
                println("\n== Envía ==")
                print("Ingresa el número de teléfono al que deseas enviar dinero: ")
                val numeroDestino = readLine() ?: ""
                print("Ingresa el valor a enviar: ")
                val valorEnvio = readLine()?.toIntOrNull() ?: continue

                if (valorEnvio <= saldoDisponible) {
                    println("Envío exitoso.")
                    saldoDisponible -= valorEnvio
                } else {
                    println("No tienes suficiente saldo para realizar este envío.")
                }
            }
            3 -> {
                println("\n== Recarga ==")
                print("Ingresa el valor a recargar: ")
                val valorRecarga = readLine()?.toIntOrNull() ?: continue

                print("¿Confirmar recarga? (Sí/No): ")
                val confirmacion = readLine() ?: ""
                if (confirmacion.equals("Sí", true)) {
                    println("Recarga exitosa.")
                    saldoDisponible += valorRecarga
                } else {
                    println("Recarga cancelada.")
                }
            }
            4 -> {
                println("Saliendo de Nequi. ¡Hasta luego!")
                return
            }
            else -> println("Opción inválida.")
        }

        println("Saldo disponible: $saldoDisponible")
    }
}


    return (100000..999999).random()
}
