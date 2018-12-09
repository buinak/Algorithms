package test.algorithms.searching

import main.algorithms.searching.binarySearch
import main.algorithms.searching.plainSearch
import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_TESTS
import main.utils.generateRandomList
import kotlin.random.Random

class SearchTest {
    @org.junit.Test
    fun plainSearch() {
        //slower than binary
        for (i in 1..AMOUNT_OF_TESTS / 4) {
            val distinctRandomList = generateRandomList(Random.nextInt(100, 10000), 0..1234567)
                .distinct()

            distinctRandomList.forEachIndexed { index, element ->
                assertEquals(index, plainSearch(distinctRandomList, element))
            }
        }
    }

    @org.junit.Test
    fun binarySearch() {
        //I just didn't feel like removing this

        /*
        //A sorted list containing an odd amount of integers.
        val oddList = arrayListOf(1, 3, 5, 9, 13, 20, 77)
        //A sorted list containing an even amount of integers.
        val evenList = arrayListOf(2, 3, 5, 7, 11, 16)
        //An unsorted list containing integers.
        val unsortedList = arrayListOf(17, 3, 1, 5, 7, 20)
        //A list containing an even amount of random distinct numbers
        val evenRandomList = generateRandomList(100, 0..255).distinct().sorted()
        //A list containing an odd amount of random distinct numbers
        val oddRandomList = generateRandomList(111, 0..255).distinct().sorted()
        //A list containing a random amount of random distinct numbers
        val randomRandomList = generateRandomList(Random.nextInt(5, 1000), 0..255).distinct().sorted()
        */

        for (i in 1..AMOUNT_OF_TESTS) {
            val sortedDistinctRandomList = generateRandomList(Random.nextInt(100, 10000), 0..1234567)
                .sorted()
                .distinct()

            sortedDistinctRandomList.forEachIndexed { index, element ->
                    assertEquals(index, binarySearch(sortedDistinctRandomList, element))
                }
        }
    }
}