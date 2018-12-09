package test.algorithms.sorting

import main.algorithms.sorting.heapSort
import main.utils.generateRandomList
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_TESTS
import kotlin.random.Random

class HeapSortTest {

    @Test
    fun heapSort() {
        for (i in 1..AMOUNT_OF_TESTS) {
            val testList = generateRandomList(Random.nextInt(2, 10000), 1..1234567)
            val sortedList = testList.sorted()
            heapSort(testList).also { assertEquals(testList, sortedList) }
        }
    }
}