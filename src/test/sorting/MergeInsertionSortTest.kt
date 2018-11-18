package test.sorting

import main.algorithms.sorting.mergeInsertionSort
import main.utils.generateRandomList
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_LISTS
import kotlin.random.Random

class MergeInsertionSortTest {

    @Test
    fun mergeInsertionSort() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val testList = generateRandomList(Random.nextInt(2, 10), 1..1234567)
            val sortedList = testList.sorted()
            mergeInsertionSort(testList)
            assertEquals(testList, sortedList)
        }
    }
}