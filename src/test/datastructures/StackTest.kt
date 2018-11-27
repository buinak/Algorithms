package test.datastructures

import main.datastructures.Stack
import org.junit.Test

import test.TestConstants
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackTest {

    @Test
    fun pushAndPopShouldWork() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val newStack = Stack<Int>()
            val newList = ArrayList<Int>()
            val numberOfElements = Random.nextInt(1, 2000)

            for (j in 1..numberOfElements) Random.nextInt(1, 10000).run {
                newStack.push(this)
                newList.add(this)
            }
            for (number in newList.reversed()) assertEquals(number, newStack.pop())
        }
    }

    @Test
    fun contains() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS) {
            val newStack = Stack<Int>()
            val list = ArrayList<Int>()
            (1..Random.nextInt(1, 2000)).forEach {
                Random.nextInt(1, 1234567).run {
                    list.add(this)
                    newStack.push(this)
                }
            }
            list.forEach { assertTrue(newStack.contains(it)) }
        }
    }

    @Test
    fun hasNext() {
        val stack = Stack<Int>()
        assertTrue(stack.isEmpty())
        stack.push(10)
        assertFalse(stack.isEmpty())
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun size() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val newStack = Stack<Int>()
            val numberOfElements = Random.nextInt(1, 2000)
            for (j in 1..numberOfElements) newStack.push(Random.nextInt(1, 1000))
            assertEquals(numberOfElements, newStack.size())
        }
    }
}