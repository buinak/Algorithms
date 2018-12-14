package test.algorithms.mathematics

import main.algorithms.mathematics.raiseToPower
import org.junit.Test
import test.TestConstants
import kotlin.random.Random
import kotlin.test.assertEquals

class PowerTest {

    @Test
    fun raiseToPowerTest() {
        for (j in 1..5) {
            for (i in 1..(TestConstants.AMOUNT_OF_TESTS * 10000)) {
                var num = Random.nextInt(1, 100000)
                var pow = Random.nextInt(1, 4)
                assertEquals(Math.pow(num.toDouble(), pow.toDouble()).toLong(),
                    raiseToPower(num.toLong(), pow)
                )
            }
            for (i in 1..(TestConstants.AMOUNT_OF_TESTS * 10000)) {
                var num = Random.nextInt(1, 1000)
                var pow = Random.nextInt(1, 6)
                assertEquals(Math.pow(num.toDouble(), pow.toDouble()).toLong(),
                    raiseToPower(num.toLong(), pow)
                )
            }
            for (i in 1..(TestConstants.AMOUNT_OF_TESTS * 10000)) {
                var num = Random.nextInt(1, 100)
                var pow = Random.nextInt(1, 8)
                assertEquals(Math.pow(num.toDouble(), pow.toDouble()).toLong(),
                    raiseToPower(num.toLong(), pow)
                )
            }
        }
    }

    @Test
    fun raiseToPowerBigTest() {
    }
}