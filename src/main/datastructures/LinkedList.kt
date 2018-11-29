package main.datastructures

/**
 * A Linked list is a data structure in which every element in the list stores a pointer
 * to the next element of the list.
 * This allows the list to be truly dynamic* at the cost of extra memory.
 *
 *
 * Time complexity:
 *      O(1) add()
 *      O(n) get()
 *      O(n) contains()
 *
 * This implementation is a singly-linked list of elements.
 * Supports add(), get(i), and size()
 *
 *
 * * Array lists, despite having O(1) adding, sometimes have to re-size themselves and re-add
 *      all the elements, thus making the performance worse.
 *
 * @author Konstantin Buinak (https://github.com/buinak)
 */
class LinkedList<T> {

    private lateinit var head: Node<T>
    private lateinit var tail: Node<T>

    private var length: Int = 0

    fun add(t: T) {
        when (length) {
            0 -> head = Node(t)
            1 -> {
                tail = Node(t)
                head.nextNode = tail
            }
            else -> {
                tail.nextNode = Node(t)
                tail = tail.nextNode!!
            }
        }
        length++
    }

    fun get(index: Int): T? {
        if (index >= length) return null
        if (index == 0) return head.contents
        var currNode = head
        try {
            for (i in 0 until index) {
                currNode = currNode.nextNode!!
            }
        } catch (e: Exception){
            println()
        }
        return currNode.contents
    }

    fun contains(element: T): Boolean {
        if (!::head.isInitialized) return false
        if (head.contents == element) return true

        var currElement: Node<T>? = head
        while (currElement != null) if (currElement.nextNode?.contents == element) {
            return true
        } else currElement = currElement.nextNode
        return false
    }

    fun size() = length
    fun isEmpty() = length == 0

    inner class Node<T>(val contents: T, var nextNode: Node<T>? = null)
}