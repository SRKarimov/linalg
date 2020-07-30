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

    fun plus(vector: Vector): Vector {
        if (coordinates.size != vector.coordinates.size)
            throw IllegalArgumentException("Coordinates must be nonempty")

        return Vector(
                coordinates.zip(vector.coordinates).map { it.first.plus(it.second) }
        )
    }
}
