package test.algorithms.mathematics

import main.algorithms.mathematics.findLeastCommonMultiple
import org.junit.Test
import test.TestConstants
import kotlin.random.Random
import kotlin.test.assertEquals

class LCMTest {

    @Test
    fun findLeastCommonMultipleTest() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS * 10){
            var randomNumber = Random.nextInt(1, 500)
            var randomNumber2 = Random.nextInt(1, 500)
            var lcm = findLeastCommonMultiple(randomNumber, randomNumber2)
            var lcmFor: Int = 0
            for (i in 1..randomNumber * randomNumber2){
                if (i % randomNumber == 0 && i % randomNumber2 == 0) {
                    lcmFor = i
                    break
                }
            }
            assertEquals(lcm, lcmFor)
        }
    }
}