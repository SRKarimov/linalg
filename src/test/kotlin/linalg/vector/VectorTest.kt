package linalg.vector

import org.junit.Test
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class VectorTest {

    @Test
    fun `When vectors are equals then return True`() {
        val vectorSrc = Vector(listOf(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0))
        val vectorDst = Vector(listOf(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0))

        assertTrue { vectorSrc == vectorDst }
    }

    @Test
    fun `When vectors are not equals then return False`() {
        val vectorSrc = Vector(listOf(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0))
        val vectorDst = Vector(listOf(1.0, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0))

        assertFalse { vectorSrc == vectorDst }
    }

    @Test
    fun `When size of vectors are different then return False`() {
        val vectorSrc = Vector(listOf(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0))
        val vectorDst = Vector(listOf(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9))

        assertFalse { vectorSrc == vectorDst }
    }

    @Test
    fun `When vector is empty then IllegalArgumentException thrown`() {
        assertFailsWith(IllegalArgumentException::class) {
            Vector(listOf())
        }
    }

    @Test
    fun `When vector is not null and execute toString then expected a string`() {
        val vector = Vector(listOf(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0))

        assertEquals("Vector: [1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0]", vector.toString())
    }

    @Test
    fun `When add a vector to another vector then result is sum of vectors`() {
        val vectorSrc = Vector(listOf(1.1, 2.2))
        val vectorDst = Vector(listOf(3.3, 4.4))

        val result = vectorSrc.plus(vectorDst, 3)
        assertEquals(Vector(listOf(4.400, 6.600)), result)
    }

    @Test
    fun `When add a vector to another vector with different size then IllegalArgumentException thrown`() {
        val vectorSrc = Vector(listOf(1.1, 2.2))
        val vectorDst = Vector(listOf(3.3, 4.4, 5.5))

        assertFailsWith(IllegalArgumentException::class) {
            vectorSrc.plus(vectorDst, 3)
        }
    }

    @Test
    fun `plus`() {
        val vectorSrc = Vector(listOf(8.218, -9.341))
        val vectorDst = Vector(listOf(-1.129, 2.111))

        val result = vectorSrc.plus(vectorDst, 3)
        assertEquals(Vector(listOf(7.089, -7.230)), result)
    }
    @Test
    fun `minus`() {
        val vectorSrc = Vector(listOf(7.119, 8.215))
        val vectorDst = Vector(listOf(-8.223, 0.878))

        val result = vectorSrc.minus(vectorDst, 3)
        assertEquals(Vector(listOf(15.342, 7.337)), result)
    }
    @Test
    fun `scalar multiply`() {
        val vectorSrc = Vector(listOf(1.671, -1.012, -0.318))

        val result = vectorSrc.multiply(7.41, 3)
        assertEquals(Vector(listOf(12.382, -7.499, -2.356)), result)
    }
}
