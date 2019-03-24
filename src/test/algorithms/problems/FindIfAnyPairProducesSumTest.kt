package test.algorithms.problems

import main.utils.generateRandomList
import org.junit.Test
import test.TestConstants
import kotlin.random.Random

class FindIfAnyPairProducesSumTest {

    @Test
    fun findAnyPairProducesSumNaive() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val list = generateRandomList(20, 1..100)
            val rndInt = Random.nextInt(1, 19)
            var rndIntSecond = Random.nextInt(1, 19)
            while (rndIntSecond == rndInt) rndIntSecond = Random.nextInt(1, 19)
        }
    }

    @Test
    fun findAnyPairProducesSumBinarySearch() {
    }

    @Test
    fun findAnyPairProducesSumLinear() {
    }
}