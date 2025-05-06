package com.paulina.introkotlin903.temasKotlin

fun main(){
    println("Ingrese el sueldo del empleado:")
    // readln permite leer un valor leyendolo desde consola
    val sueldo = readln().toDouble()

    if(sueldo > 3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }
}
