package com.paulina.introkotlin903.temasKotlin
fun main (){
    /*
    Range: parecido al range en python
    Si yo quieroimprimir del 1 al 4
    1..4 = 1,2,3,4
    -Si solo quisieramos imprimir del 1 al 3
    1..<4= 1,2,3
    -Si lo queremos imprimir al reves
    4 downTo 1 = 4,3,2,1
    - Tambien podemos decirle de cuanto en cuanto
    1..5 step 2 = 1,3,5
    -Rangos para caracteres
    'a'..'z'= a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
     */


    for (num in 1..5){
        println(num)
    }
    val frutas = listOf("Manzana","Pera","Frambuesa")
    for(fruta in frutas){
        println(fruta)
    }
    val n=10
    var d=0
    while (d<n){
        println(d)
        d++

    }
    println("*"+"*")
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

}