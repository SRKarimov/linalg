/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package linalg

import linalg.vector.Vector

fun main(args: Array<String>) {
    val vectorOne = Vector(listOf(-0.221, 7.437))
    println(vectorOne.magnitude(3))

    val vectorTwo = Vector(listOf(8.813, -1.331, -6.247))
    println(vectorTwo.magnitude(3))

    val vectorThree = Vector(listOf(5.581, -2.136))
    println(vectorThree.normalized(3))

    val vectorFour = Vector(listOf(1.996, 3.108, -4.554))
    println(vectorFour.normalized(3))
}
