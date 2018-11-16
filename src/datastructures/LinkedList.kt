package datastructures

/**
 * Singly-linked list of elements.
 * Supports add(), get(i), getLast() and size()
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
            2 -> {
                tail.nextNode = Node(t)
                tail = tail.nextNode!!
            }
        }
        length++
    }

    fun getLast(): Node<T>? = if (length > 1) tail else null

    fun get(index: Int): T? {
        if (index >= length) return null
        if (index == 0) return head.contents
        var currNode = head
        for (i in 0 until index) {
            currNode = currNode.nextNode!!
        }
        return currNode.contents
    }

    fun size() = length


    inner class Node<T>(val contents: T, var nextNode: Node<T>? = null)
}