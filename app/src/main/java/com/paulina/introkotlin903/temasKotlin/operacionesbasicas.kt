package com.paulina.introkotlin903.temasKotlin

fun main() {
    var opcion: Int

    do {
        println("\nElige una opcion:")
        println("1 - Suma")
        println("2 - Multiplicacion")
        println("3 - Resta")
        println("4 - Dividir")
        println("5 - Salir")

        opcion = readln().toInt()

        if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
            println("Ingrese su primer numero:")
            val numero1 = readln().toDouble()
            println("Ingrese su segundo numero:")
            val numero2 = readln().toDouble()

            if (opcion == 1) {
                val suma = numero1 + numero2
                println("La suma de $numero1 y $numero2 es $suma")
            }

            if (opcion == 2) {
                val multiplicacion = numero1 * numero2
                println("La multiplicacion de $numero1 y $numero2 es $multiplicacion")
            }

            if (opcion == 3) {
                val resta = numero1 - numero2
                println("La resta de $numero1 y $numero2 es $resta")
            }

            if (opcion == 4) {

                    val division = numero1 / numero2
                    println("La division de $numero1 entre $numero2 es $division")

            }
        } else if (opcion != 5) {
            println("Opcion no válida. Intenta de nuevo.")
        }

    } while (opcion != 5)

    println("Saliendo")
}
