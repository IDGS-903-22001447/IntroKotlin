package com.paulina.introkotlin903.temasKotlin

fun main(){
   /*
   List
   MutableList
   Set
   Mutableset
   Map
   MutableSet
    */

    var lista = listOf<String>("Lunes","Martes")
    println(lista)
    println(lista.size)
    println(lista.get(8))
    println(lista.contains("Lunes"))
    print(lista.indexOf("Martes"))
    print(lista.first())
    print(lista.last())

    var listamutable = mutableListOf<String>("Lunes","Martes")
    println(listamutable)
    listamutable.add("Miercoles")
    println(listamutable)
    listamutable.removeAt(0)
    listamutable.add(0,"Domingo")
    listamutable.remove("Lunes")
    println(listamutable)


}
