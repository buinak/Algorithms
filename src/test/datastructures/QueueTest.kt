package test.datastructures

import main.datastructures.Queue
import org.junit.Assert.*
import org.junit.Test
import test.TestConstants
import kotlin.random.Random

class QueueTest {

    @Test
    fun enqueueAndDequeueShouldWork() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val newQueue = Queue<Int>()
            val newList = ArrayList<Int>()
            val numberOfElements = Random.nextInt(1, 2000)

            for (j in 1..numberOfElements) Random.nextInt(1, 10000).run {
                newQueue.enqueue(this)
                newList.add(this)
            }
            for (number in newList) kotlin.test.assertEquals(number, newQueue.dequeue())
        }
    }

    @Test
    fun hasNext() {
        val queue = Queue<Int>()
        assertTrue(queue.isEmpty())
        queue.enqueue(10)
        assertFalse(queue.isEmpty())
        queue.dequeue()
        assertTrue(queue.isEmpty())
    }

    @Test
    fun size() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val newQueue = Queue<Int>()
            var numberOfElements = Random.nextInt(1, 2000)
            for (j in 1..numberOfElements) newQueue.enqueue(Random.nextInt(1, 1000))
            for (j in 1..numberOfElements / 4) if (Random.nextBoolean()) {
                numberOfElements--
                newQueue.dequeue()
            }
            assertEquals(numberOfElements, newQueue.size())
        }
    }

    @Test
    fun contains() {
        for (i in 1..5) {
            val newQueue = Queue<Int>()
            val list = ArrayList<Int>()
            (1..Random.nextInt(1, 5)).forEach {
                Random.nextInt(1, 1234567).run {
                    list.add(this)
                    newQueue.enqueue(this)
                }
            }
            list.forEach { assertTrue(newQueue.contains(it)) }
        }
    }
}