package test.utils

import org.junit.Test

import org.junit.Assert.*
import test.TestConstants.AMOUNT_OF_TESTS
import main.utils.checkSorted
import main.utils.generateRandomList
import main.utils.isBinarySearcheable
import main.utils.swap
import kotlin.random.Random

class ListExtensionsTest {

    @Test
    fun swap() {
        for (i in 1..AMOUNT_OF_TESTS){
            val list = generateRandomList(Random.nextInt(2, 25000), 1..1234567)
            list.forEachIndexed { index, element ->
                val rndIndex = Random.nextInt(0, list.size - 1)
                val rndElement = list[rndIndex]
                list.swap(index, rndIndex)

                assertEquals(list[rndIndex], element)
                assertEquals(list[index], rndElement)
            }
        }
    }

    @Test
    fun checkSorted() {
        for (i in 1..AMOUNT_OF_TESTS){
            var list: List<Int> = generateRandomList(Random.nextInt(2, 25000), 1..1234567)
            var isSorted = Random.nextBoolean()
            if (isSorted){
                list = list.sorted()
            }
            assertEquals(isSorted, list.checkSorted())
        }
    }

    @Test
    fun isBinarySearcheable() {
        for (i in 1..AMOUNT_OF_TESTS){
            var list: List<Int> = generateRandomList(Random.nextInt(2, 25000), 1..1234567)
            var isBinarySearchable = Random.nextBoolean()
            if (isBinarySearchable){
                list = list.sorted().distinct()
            }
            assertEquals(isBinarySearchable, list.isBinarySearcheable())
        }
    }
}