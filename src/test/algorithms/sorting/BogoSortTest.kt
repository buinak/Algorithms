package test.algorithms.sorting

import main.algorithms.sorting.bogoSort
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_TESTS
import main.utils.generateRandomList
import kotlin.random.Random

class BogoSortTest {

    @Test
    fun bogoSort() {
        for (i in 1..AMOUNT_OF_TESTS) {
            val testList = generateRandomList(Random.nextInt(2, 9), 1..30)
            val sortedList = testList.sorted()
            bogoSort(testList).also { assertEquals(testList, sortedList) }
        }
    }
}