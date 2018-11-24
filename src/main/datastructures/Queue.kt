package main.datastructures

/**
 * A basic Queue implementation using a linked list behind to link nodes.
 * A Queue is a data structure that implements the First In—First Out principle.
 *
 * Time complexity is O(1) for both enqueueing - putting an element of the
 * top of the queue and dequeueing—taking an element from the bottom of the queue.
 *
 * Using a linked list involves higher memory usage due to pointers but is very
 * simple in implementation, which is its main advantage.
 *
 * Supports basic enqueue(), dequeue(), contains(), size() and isEmpty() methods.
 */
class Queue<T> {

    // The head variable contains the head of the queue—the element to be dequeueed first.
    private var head: Node<T>? = null
    /* The tail variable contains the last added element of the queue.
       The exception is when there is only 1 element in the queue, in which case the element
       is the head.
    */
    private var tail: Node<T>? = null
    // The size of the queue.
    private var size = 0

    /**
     * Puts an element on the top of the queue.
     * There are three cases to cover:
     *     The first case, where the queue does not contain any elements yet.
     *     In this case, we create the node and assign the head variable to equal
     *     to the newly made node.
     *
     *     The second case, where the queue contains only one element.
     *     In this case, we create the node as assign the tail variable to equal
     *     to the newly made node. We also link the head and the tail together.
     *
     *     The third case, where the queue contains >= 2 elements.
     *     In this case, we link the tail to the newly made node and reassign the tail
     *     to be the newly made node.
     */

    fun enqueue(element: T) {
        when (size) {
            0 -> head = Node(element)
            1 -> Node(element, head).run {
                tail = this
                head?.nextNode = this
            }
            else -> Node(element, tail).run {
                tail?.nextNode = this
                tail = this
            }
        }.also { size++ }
    }

    fun dequeue(): T? {
        val result = head?.contents
        when (size) {
            0 -> return null
            2 -> tail = null
        }
        head = head?.nextNode
        size--
        return result
    }

    fun contains(element: T): Boolean {
        var currElement: Node<T>? = head
        while (currElement != null) if (currElement == element) return true
        else currElement = head?.nextNode
        return false
    }

    fun isEmpty() = size == 0
    fun size() = size

    inner class Node<T>(val contents: T,
                        var previousNode: Node<T>? = null,
                        var nextNode: Node<T>? = null)
}

fun main(args: Array<String>) {
    val q = Queue<Int>()
    q.enqueue(1)
    println("q contains $1 = ${q.contains(1)}")
    println("q contains $2 = ${q.contains(2)}")
}