package org.example.controllers
import java.util.*

import java.util.Scanner

val matriu = Array(20){Array(15) {"_"} }
fun main() {
    var opcio = 0
    val scanner= Scanner(System.`in`)

    while (opcio != 4) {
        opcio = mostrarMenu(scanner)
        when (opcio) {
            1 -> println() // Borrar sala
            2 -> visualizarSeients()
            3 -> getReserba(scanner)
            4 -> println("Un placer hacer negocios, hasta otra :)")

        }
    }

}

fun mostrarMenu(scanner: Scanner) : Int{
    var opcio : Int
    println("""
        Menu:
        1 - Buidar sala
        2 - Visualitzar seients disponibles
        3 - Reserva de seients
        4 - Sortir
        
    """.trimIndent())
    print("Elige tu opcion: ")
    opcio = scanner.nextInt()
    return opcio
}
fun visualizarSeients () {
    println("Esta es la sala con los asientos disponibles")
    println("   los asientos marcados con X estan ocupados")
    println("   los asientos marcados con _ estan libres")

    for (fila in 0 until  20) {
        for (butaca in 0 until 15) {
            print(matriu[fila][butaca])
        }
        println()
    }
}

fun getReserba (scanner: Scanner) {
    println("Para reserbar un asiento introduce su fila y su butaca")
    print("Introduce la fila: ")
    var fila = scanner.nextInt()
    print("Introduce la butaca: ")
    var butaca = scanner.nextInt()
    reserba(fila, butaca)
}

fun reserba (fila:Int, butaca:Int) {
    if (fila in 0..20 && butaca in 0..15) {
        matriu[fila][butaca] = "X" // Suponiendo que matriu es una matriz bidimensional definida previamente
        println("Reserva realizada correctamente")
    } else {
        println("Error: Fila o butaca fuera de rango")
    }
}

fun vaciarSala (){
    for (fila in 0 until 20) {
        for (butaca in 0 until 15) {
            matriu [fila][butaca] = "_"
        }
    }
}