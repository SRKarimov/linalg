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
    fun `When add a vector to another vector then result summ of vectors`() {
        val vectorSrc = Vector(listOf(1.1, 2.2))
        val vectorDst = Vector(listOf(3.3, 4.4))

        val result = vectorSrc.plus(vectorDst)
        assertEquals(Vector(listOf(4.4, 6.6000000000000005)), result)
    }
}
