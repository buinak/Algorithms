package tests.sorting

import algorithms.sorting.*
import org.junit.Test

import org.junit.Assert.*
import tests.TestConstants.AMOUNT_OF_LISTS
import utils.generateRandomList
import kotlin.random.Random

class BubbleSortTest {

    @Test
    fun bubbleSort() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val testList = generateRandomList(Random.nextInt(20, 300), 1..3033)
            val sortedList = testList.sorted()
            bubbleSort(testList).also { assertEquals(testList, sortedList) }
        }
    }
}