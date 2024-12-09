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
            1 -> vaciarSala()
            2 -> visualizarSeients()
            3 -> getReserba(scanner)
            4 -> println("Un placer hacer negocios, hasta otra :)")

        }
    }

}

/**
 * Se muestra el menu y recibe la eleccion del usurio
 * @author Iván Salamanca
 *
 * @param scanner permite escanear la eleccion del usuario
 * @return Devuelve la seleccion de el usuario
 */
fun mostrarMenu(scanner: Scanner) : Int{
    var opcio : Int
    println("""
        --------Menu--------
        1 - Vaciar Sala
        2 - Visualizar asientos disponibles 
        3 - Reserva de asientos
        4 - Exit
        --------------------
        
    """.trimIndent())
    print("Elige tu opcion: ")
    opcio = scanner.nextInt()
    return opcio
}

/**
 * Muesta la sala de cine tal y como este
 * @author Iván Salamanca
 */
fun visualizarSeients () {
    println("Esta es la sala con los asientos disponibles")
    println("   los asientos marcados con X estan ocupados")
    println("   los asientos marcados con _ estan libres")

    for (fila in 0 until  20) {
        for (butaca in 0 until 15) {
            print("${matriu[fila][butaca]} ")
        }
        println()
    }
}

/**
 * Recibe los dos numeros para reserbar la butaca y llama a la reserba
 * @author Iván Salamanca
 *
 * @param scanner Permite scannear la eleccion del usuario
 */
fun getReserba (scanner: Scanner) {
    println("Para reserbar un asiento introduce su fila y su butaca")
    //Introduccion fila
    print("Introduce la fila: ")
    var fila = scanner.nextInt()
    //Introduccion Butaca
    print("Introduce la butaca: ")
    var butaca = scanner.nextInt()
    reserba(fila, butaca) // Llamamamos a la reserba y le pasamos los dos numeros para que se complete
}

/**
 * Efectua la reserba dentro de la matriz cambiando "_" por "X"
 * @author Iván Salamanca
 *
 * @param fila El numero de fila para la reserba
 * @param butaca El numero de butaca dentro de la fila
 */
fun reserba (fila:Int, butaca:Int) {
    if (fila in 0..20 && butaca in 0..15) {
        matriu[fila][butaca] = "X" // Suponiendo que matriu es una matriz bidimensional definida previamente
        println("Reserva realizada correctamente")
    } else {
        println("Error: Fila o butaca fuera de rango")
        println("Vuelve a introduccir la seleccion de menu")
    }
}

/**
 * Vaciamos la sala y ponemos  _ como asiento bacio
 * @author Iván Salamanca
 */
fun vaciarSala (){
    for (fila in 0 until 20) {
        for (butaca in 0 until 15) {
            matriu [fila][butaca] = "_"
        }
    }
    println("__________________________")
    println("Sala borrada correctamente")
    println("__________________________")

}