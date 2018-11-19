package main.datastructures

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Stack<T> {
    private var head: Node<T>? = null
    private var length = 0

    fun push(element: T) {
        head = when (head == null){
            true -> Node(element)
            else -> Node(element, head)
        }.also { length++ }
    }

    fun pop(): T? {
        if (length == 0) return null else length--
        return head?.contents
            .also { head = head?.nextNode }
    }

    fun isEmpty(): Boolean = length == 0
    fun size() = length

    inner class Node<T>(val contents: T, var nextNode: Node<T>? = null)
}