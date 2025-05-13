package com.paulina.introkotlin903.temasKotlin
// funcion con devolucion se especifica el tipo de devolucion
fun sum(x: Int, y:Int): Int {
    return x + y
}
// funcion de linea se le quta el tipo de devolucion y el return y las llaves
fun sum2(x: Int, y:Int)  = x + y

fun main(){
    saludo()
    println(sum(2,3))
    println(sum2(2,3))
}

fun saludo(){
    return println("Hola")
}