package test.sorting

import main.algorithms.sorting.mergeSortSentinel
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_TESTS
import main.utils.generateRandomList
import kotlin.random.Random

class MergeSortSentinelTest {

    @Test
    fun mergeSortSentinel() {
        for (i in 1..AMOUNT_OF_TESTS) {
            val testList = generateRandomList(Random.nextInt(2, 10000), 1..1234567)
            val sortedList = testList.sorted()
            mergeSortSentinel(testList).also { assertEquals(testList, sortedList) }
        }
    }
}