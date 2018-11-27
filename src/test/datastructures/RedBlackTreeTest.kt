package test.datastructures

import main.datastructures.RedBlackTree
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants
import kotlin.random.Random

class RedBlackTreeTest {

    @Test
    fun insert() {
    }

    @Test
    fun orderedTraverse() {
    }

    @Test
    fun breadthFirstTraverse() {
    }

    @Test
    fun getLevel() {
    }

    @Test
    fun contains() {
    }

    @Test
    fun getMinimum() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val list = ArrayList<Int>()
            val tree = RedBlackTree<Int>()
            for (j in 1..5000){
                Random.nextInt(1, 1234567).run {
                    if (tree.contains(this)) return@run
                    tree.insert(this)
                    list.add(this)
                }
            }
            assertTrue(list == list.distinct())
            assertEquals(list.min(), tree.getMinimum())
        }
    }
}