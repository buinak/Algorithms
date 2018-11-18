package test.datastructures

import main.datastructures.LinkedList
import org.junit.Test

import org.junit.Assert.*
import org.junit.BeforeClass
import test.TestConstants.AMOUNT_OF_LISTS
import kotlin.random.Random

class LinkedListTest {


    @Test
    fun addAndGetShouldWork() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val linkedList = LinkedList<Int>()
            val standardList = ArrayList<Int>()
            (1..100).forEach {
                val randomElement = Random.nextInt(0, 1234567)
                linkedList.add(randomElement)
                standardList.add(randomElement)
            }
            standardList.forEachIndexed { index, element -> assertEquals(element, linkedList.get(index)) }
        }
    }

    @Test
    fun size() {
        for (i in 1..AMOUNT_OF_LISTS) {
            val linkedList = LinkedList<Int>()
            val rndSize = Random.nextInt(1, 12345)
            (1..rndSize).forEach { linkedList.add(Random.nextInt(1, 1234567)) }
            assertEquals(linkedList.size(), rndSize)
        }
    }
}