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
    // similar al case en switch case en java
    val mes = "1"
    when(mes){
        "1"-> println("enero")
        "2"-> println("febrero")
        "3"-> println("marzo")
        else -> println("mes desconocido")
    }
    print(1..5)
}
