package test.sorting

import main.algorithms.sorting.insertionSort
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_TESTS
import main.utils.generateRandomList
import kotlin.random.Random

class InsertionSortTest {

    @Test
    fun insertionSort() {
        for (i in 1..AMOUNT_OF_TESTS) {
            val testList = generateRandomList(Random.nextInt(25, 500), 0..3002)
            val sortedList = testList.sorted()
            insertionSort(testList).also { assertEquals(testList, sortedList) }
        }
    }
}