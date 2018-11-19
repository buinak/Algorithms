package test.datastructures

import main.datastructures.BinarySearchTree
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants
import kotlin.random.Random

class BinarySearchTreeTest {

    @Test
    fun insert() {
    }

    @Test
    fun contains() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val tree = BinarySearchTree<String>()
            var stringList = ArrayList<String>()
            for (j in 1..Random.nextInt(20, 100)) {
                var randomString = ""
                for (i in 1..Random.nextInt(2, 10)) {
                    randomString += Random.nextInt(20, 100).toChar()
                }
                stringList.add(randomString)
                tree.insert(randomString)
            }
            stringList.forEach { assertTrue(tree.contains(it)) }
        }
    }

    @Test
    fun depthFirstTraverseWithLevel() {
    }

    @Test
    fun depthFirstTraverse() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS){
            val list = ArrayList<Int>()
            val tree = BinarySearchTree<Int>()
            for (j in 1..Random.nextInt(20, 100)){
                Random.nextInt(1, 123456).run {
                    list.add(this)
                }
            }
            for (element in list.distinct()){
                tree.insert(element)
            }
            var sortedInitialList = list.distinct().sorted()
            var sortedTreeList = ArrayList<Int>()
            tree.depthFirstTraverse({ element -> sortedTreeList.add(element)})
            assertEquals(sortedInitialList, sortedTreeList)
        }
    }

    @Test
    fun breadthFirstTraverse() {
    }

    @Test
    fun getLevel() {
    }
}