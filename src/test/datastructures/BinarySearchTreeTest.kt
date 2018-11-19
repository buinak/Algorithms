package test.datastructures

import main.datastructures.BinarySearchTree
import org.junit.Test

import org.junit.Assert.*
import test.TestConstants
import kotlin.random.Random

class BinarySearchTreeTest {

    @Test
    fun insert() {
        TODO()
    }

    @Test
    fun contains() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS) {
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
    fun deletingRootShouldWork() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS) {
            val tree = BinarySearchTree<Int>()
            val list = ArrayList<Int>()
            for (j in 1..Random.nextInt(20, 1000)) {
                Random.nextInt(1, 123456).run {
                    if (!tree.contains(this)) {
                        list.add(this)
                        tree.insert(this)
                    }
                }
            }
            val listBeforeDeletion = ArrayList<Int>()
            tree.breadthFirstTraverse { element -> listBeforeDeletion.add(element) }
            assertTrue(listBeforeDeletion.containsAll(list))
            assertEquals(list[0], listBeforeDeletion[0])
            tree.delete(list[0])
            list.remove(list[0])
            val listAfterDeletion = ArrayList<Int>()
            tree.breadthFirstTraverse { element -> listAfterDeletion.add(element) }
            assertTrue(listAfterDeletion.containsAll(list))
        }
    }

    @Test
    fun deletingRandomShouldWork() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS) {
            val tree = BinarySearchTree<Int>()
            val list = ArrayList<Int>()
            for (j in 1..Random.nextInt(20, 22)) {
                Random.nextInt(1, 123).run {
                    if (!tree.contains(this)) {
                        list.add(this)
                        tree.insert(this)
                    }
                }
            }
            val sortedList = ArrayList(list.sorted())
            val listBeforeDeletion = ArrayList<Int>()
            tree.depthFirstTraverse { element -> listBeforeDeletion.add(element)}
            assertTrue(listBeforeDeletion.containsAll(sortedList))
            assertEquals(sortedList[0], listBeforeDeletion[0])

            for (i in 1 until sortedList.size){
                val randomElement = sortedList.shuffled().first()
                tree.delete(randomElement)
                sortedList.remove(randomElement)
                val listAfterDeletion = ArrayList<Int>()
                tree.depthFirstTraverse { element -> listAfterDeletion.add(element) }
                assertEquals(sortedList, listAfterDeletion)
            }
        }
    }

    @Test
    fun depthFirstTraverseWithLevel() {
        TODO()
    }

    @Test
    fun depthFirstTraverse() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS) {
            val list = ArrayList<Int>()
            val tree = BinarySearchTree<Int>()
            for (j in 1..Random.nextInt(20, 100)) {
                Random.nextInt(1, 123456).run {
                    list.add(this)
                }
            }
            for (element in list.distinct()) {
                tree.insert(element)
            }
            var sortedInitialList = list.distinct().sorted()
            var sortedTreeList = ArrayList<Int>()
            tree.depthFirstTraverse({ element -> sortedTreeList.add(element) })
            assertEquals(sortedInitialList, sortedTreeList)
        }
    }

    @Test
    fun breadthFirstTraverse() {
        TODO()
    }

    @Test
    fun getLevel() {
        TODO()
    }
}