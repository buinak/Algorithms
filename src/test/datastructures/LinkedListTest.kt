package test.datastructures

import main.datastructures.lists.LinkedList
import org.junit.Assert.assertEquals
import org.junit.Test
import test.TestConstants.AMOUNT_OF_TESTS
import kotlin.random.Random
import kotlin.test.assertTrue

class LinkedListTest {


    @Test
    fun addAndGetShouldWork() {
        for (i in 1..AMOUNT_OF_TESTS) {
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
    fun containsShouldWork() {
        for (i in 1..AMOUNT_OF_TESTS) {
            val list = ArrayList<Int>()
            val linked = LinkedList<Int>()
            for (j in 1..Random.nextInt(20, 1000)) {
                Random.nextInt(1, 1234567).run {
                    if (!list.contains(this)) {
                        list.add(this)
                        linked.add(this)
                    }
                }
            }
            println()
            list.forEach { assertTrue { linked.contains(it) } }
        }
    }

    @Test
    fun size() {
        for (i in 1..AMOUNT_OF_TESTS) {
            val linkedList = LinkedList<Int>()
            val rndSize = Random.nextInt(1, 12345)
            (1..rndSize).forEach { linkedList.add(Random.nextInt(1, 1234567)) }
            assertEquals(linkedList.size(), rndSize)
        }
    }
}