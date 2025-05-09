package com.paulina.introkotlin903.temasKotlin
fun main() {
    /*
    practica3= imprimir una piramide de * segun el numero dado por el usuario
    n=5
    *
    **
    ***
    ****
    *****
    cuando se capture un 0 terminar el programa, utlizar do-while
     */
    var n: Int
    do {
        println("Ingrese un numero ")
        n = readln().toInt()
       var piramide=0
        var signo="*"
        do {
            println(signo.repeat(piramide))
            piramide++
        }while (piramide<=n)

    } while (n != 0)
    println("Programa terminado")
}