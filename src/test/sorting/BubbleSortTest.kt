package test.sorting

import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_LISTS
import main.utils.generateRandomList
import kotlin.random.Random

class BubbleSortTest {

    @Test
    fun bubbleSort() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val testList = generateRandomList(Random.nextInt(20, 300), 1..3033)
            val sortedList = testList.sorted()
            main.algorithms.sorting.bubbleSort(testList).also { assertEquals(testList, sortedList) }
        }
    }
}