package org.example.controllers
import java.util.*

data class Punt(
    var x: Float,
    var y: Float
)

fun main() {
    // crear punts utilitzant l'entrada de l'usuari
    val punt1 = llegirPunt("Introdueix les coordenades del punt 1")
    val punt2 = llegirPunt("Introdueix les coordenades del punt 2")

    // mostrar els punts inicials
    mostraPunt(punt1)
    mostraPunt(punt2)

    // aplicar translació i mostrar el resultat
    translacio(punt1, punt2)
    println("Després de la translació:")
    mostraPunt(punt1)

    // aplicar escalat i mostrar el resultat
    val factorEscalat = llegirNumero("Introdueix el factor d'escalat:").toFloat()
    escalat(punt1, factorEscalat)
    println("Després de l'escalat:")
    mostraPunt(punt1)

    // comprovació si dos punts són iguals
    val punt3 = llegirPunt("Introdueix les coordenades del punt 3")
    println("Punt1 i Punt3 són iguals? ${sonIguals(punt1, punt3)}")
}

// llegir un punt des de l'entrada de l'usuari
fun llegirPunt(missatge: String): Punt {
    println(missatge)
    val x = llegirNumero("Introdueix la coordenada X:").toFloat()
    val y = llegirNumero("Introdueix la coordenada Y:").toFloat()
    return Punt(x, y)
}

// llegir un número sense utilitzar try-catch
fun llegirNumero(missatge: String): Double {
    val scanner = Scanner(System.`in`)
    var numero: Double? = null

    while (numero == null) {
        print("$missatge ")
        if (scanner.hasNextDouble()) {
            numero = scanner.nextDouble()
        } else {
            println("Error: introdueix un número vàlid.")
            scanner.next() // Ignorar l'entrada incorrecta
        }
    }
    return numero
}

// mostrar un punt
fun mostraPunt(p: Punt) {
    println("(${p.x.format(6)}, ${p.y.format(6)})")
}

// formatar un número amb decimals
fun Float.format(digits: Int) = "%.${digits}f".format(this)

// aplicar translació a un punt
fun translacio(p: Punt, desplacament: Punt) {
    p.x += desplacament.x
    p.y += desplacament.y
}

// aplicar escalat a un punt
fun escalat(p: Punt, factor: Float) {
    p.x *= factor
    p.y *= factor
}

// comprovar si dos punts són iguals
fun sonIguals(p1: Punt, p2: Punt): Boolean {
    return p1.x == p2.x && p1.y == p2.y
}
