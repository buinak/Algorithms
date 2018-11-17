package tests.sorting

import algorithms.sorting.*
import org.junit.Test

import org.junit.Assert.*
import tests.TestConstants.AMOUNT_OF_LISTS
import utils.generateRandomList
import kotlin.random.Random

class MergeSortPlainTest {

    @Test
    fun mergeSortPlain() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val testList = generateRandomList(Random.nextInt(2, 10000), 1..1234567)
            val sortedList = testList.sorted()
            mergeSortPlain(testList).also { assertEquals(testList, sortedList) }
        }
    }
}