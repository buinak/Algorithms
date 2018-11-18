package test.sorting

import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_LISTS
import main.utils.generateRandomList
import kotlin.random.Random

class MergeSortSentinelTest {

    @Test
    fun mergeSortSentinel() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val testList = generateRandomList(Random.nextInt(2, 10000), 1..1234567)
            val sortedList = testList.sorted()
            main.algorithms.sorting.mergeSortSentinel(testList).also { assertEquals(testList, sortedList) }
        }
    }
}