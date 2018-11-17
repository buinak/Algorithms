package tests.sorting

import algorithms.sorting.bogoSort
import org.junit.Test

import org.junit.Assert.*
import tests.TestConstants.AMOUNT_OF_LISTS
import utils.generateRandomList
import kotlin.random.Random

class BogoSortTest {

    @Test
    fun bogoSort() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val testList = generateRandomList(Random.nextInt(2, 9), 1..30)
            val sortedList = testList.sorted()
            bogoSort(testList).also { assertEquals(testList, sortedList) }
        }
    }
}