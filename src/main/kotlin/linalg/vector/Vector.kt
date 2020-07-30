package linalg.vector

import java.lang.IllegalArgumentException
import java.math.RoundingMode

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
}
