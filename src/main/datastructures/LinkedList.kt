package main.datastructures

import java.lang.Exception

/**
 * Singly-linked list of elements.
 * Supports add(), get(i), and size()
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

    fun size() = length
    fun isEmpty() = length == 0

    inner class Node<T>(val contents: T, var nextNode: Node<T>? = null)
}