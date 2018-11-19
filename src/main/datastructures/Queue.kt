package main.datastructures

class Queue<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var length = 0

    fun enqueue(element: T){
        when (length){
            0 -> head = Node(element)
            1 -> Node(element, head).run {
                tail = this
                head?.nextNode = this
            }
            else -> Node(element, tail).run {
                tail?.nextNode = this
                tail = this
            }
        }.also { length++ }
    }

    fun dequeue(): T?{
        val result = head?.contents
        when (length){
            0 -> return null
            2 -> tail = null
        }
        head = head?.nextNode
        length--
        return result
    }

    fun isEmpty() = length == 0
    fun size() = length

    inner class Node<T>(val contents: T,
                        var previousNode: Node<T>? = null,
                        var nextNode: Node<T>? = null)
}