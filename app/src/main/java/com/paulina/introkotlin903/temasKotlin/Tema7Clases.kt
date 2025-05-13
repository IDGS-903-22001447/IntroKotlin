package com.paulina.introkotlin903.temasKotlin

class usuarios {
    val materia:String=""

}
class usuarios2(val id:Int, val nombre:String, val apellido:String){
    val materia:String=""
    fun hola(){
        println("Hola")
    }
}
fun main(){
    val alumno=usuarios()
    val alumno2=usuarios2(1,"Juan","Perez")
    println(alumno2.id)
    println(alumno2.nombre)
    println(alumno2.apellido)
    alumno2.hola()

}