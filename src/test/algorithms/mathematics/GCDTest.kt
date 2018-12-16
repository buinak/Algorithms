package test.algorithms.mathematics

import org.junit.Test
import kotlin.test.assertEquals

class GCDTest {

    @Test
    fun greatestCommonDivisor() {
        assertEquals(6, main.algorithms.mathematics.findGreatestCommonDivisor(12, 30))
        assertEquals(10, main.algorithms.mathematics.findGreatestCommonDivisor(20, 110))
        assertEquals(5, main.algorithms.mathematics.findGreatestCommonDivisor(20, 125))
    }
}