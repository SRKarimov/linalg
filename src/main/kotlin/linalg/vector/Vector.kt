package linalg.vector

import java.lang.IllegalArgumentException
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.sqrt

class Vector(
        private val coordinates: List<Double> = listOf()
) {
    init {
        if (coordinates.isEmpty())
            throw IllegalArgumentException("Coordinates must be nonempty")
    }

    override fun equals(other: Any?): Boolean {
        if (coordinates.size != (other as Vector).coordinates.size)
            return false

        val pairList = coordinates.zip((other as Vector).coordinates)

        return pairList.all { (src, dst) ->
            src == dst
        }
    }

    override fun toString(): String {
        return "Vector: $coordinates"
    }

    fun plus(other: Vector, scale: Int): Vector {
        if (coordinates.size != other.coordinates.size)
            throw IllegalArgumentException("Coordinates must be nonempty")

        return Vector(
                coordinates.zip(other.coordinates).map { it.first.plus(it.second).toBigDecimal().setScale(scale, RoundingMode.HALF_UP).toDouble() }
        )
    }

    fun minus(other: Vector, scale: Int): Vector {
        if (coordinates.size != other.coordinates.size)
            throw IllegalArgumentException("Coordinates must be nonempty")

        return Vector(
                coordinates.zip(other.coordinates).map { it.first.minus(it.second).toBigDecimal().setScale(scale, RoundingMode.HALF_UP).toDouble() }
        )
    }

    fun multiply(scalar: Double, scale: Int): Vector {
        return Vector(
                coordinates.map { it.times(scalar).toBigDecimal().setScale(scale, RoundingMode.HALF_UP).toDouble() }
        )
    }

    fun magnitude(scale: Int) = sqrt(coordinates.map { it.pow(2) }.sum()).toBigDecimal().setScale(scale, RoundingMode.HALF_UP).toDouble()

    fun normalized(scale: Int): Vector {
        try {
            val magnitude = magnitude(scale)
            return multiply(1.0 / magnitude, scale)
        }catch (ex: Exception) {
            throw Exception("Can not normalize the zero vector")
        }
    }
}
