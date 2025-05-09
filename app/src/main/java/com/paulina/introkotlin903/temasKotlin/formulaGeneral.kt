package com.paulina.introkotlin903.temasKotlin

fun main() {
    while (true) {
        println("Ingrese el valor de a (o escriba 'salir' para terminar):")
        val aInput = readln()
        if (aInput.lowercase() == "salir") break

        println("Ingrese el valor de b:")
        val bInput = readln()
        println("Ingrese el valor de c:")
        val cInput = readln()

        val aValido = aInput.toFloatOrNull()
        val bValido = bInput.toFloatOrNull()
        val cValido = cInput.toFloatOrNull()

        if (aValido == null || bValido == null || cValido == null) {
            println("Por favor, ingrese solo numeros validos.")
            continue
        }

        val a = aValido
        val b = bValido
        val c = cValido

        if (a == 0f) {
            println("El valor de 'a' no puede ser 0.")
            continue
        }

        val discriminante = b * b - 4 * a * c

        if (discriminante < 0) {
            println("No hay soluciones reales")
            continue
        }

        val raiz = kotlin.math.sqrt(discriminante)
        val resultado1 = (-b + raiz) / (2 * a)
        val resultado2 = (-b - raiz) / (2 * a)

        println("El valor de X1 es $resultado1 y el valor de X2 es $resultado2")

        println("¿Deseas intentar de nuevo? (si/no):")
        val respuesta = readln()
        if (respuesta.lowercase() != "si") break
    }

    println("Programa terminado.")
}
