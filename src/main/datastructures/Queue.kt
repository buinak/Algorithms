package main.datastructures

/**
 * A basic Queue implementation using linked nodes.
 * A Queue is a data structure that implements the First In—First Out principle.
 *
 * Time complexity is O(1) for both enqueueing - putting an element of the
 * top of the queue and dequeueing—taking an element from the bottom of the queue.
 *
 * Using linked nodes involves higher memory usage due to pointers but is very
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
     * Puts an element on the tail (end) of the queue.
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
            1 -> Node(element).run {
                tail = this
                head?.nextNode = this
            }
            else -> Node(element).run {
                tail?.nextNode = this
                tail = this
            }
            // Increment the field necessary for the methods to work properly.
        }.also { size++ }
    }

    /**
     * Returns the element from the head (start) of the queue.
     * It always returns the head.
     *
     * There are two extra cases to cover:
     *      The first case happens when the queue doesn't contain any elements.
     *      In this case we don't decrement the size and just return null.
     *
     *      The second case happens when the size is 2.
     *      In this case we nullify the tail of the queue so that enqueuing
     *      works correctly.
     */
    fun dequeue(): T? {
        val result = head?.contents
        when (size) {
            // If size is 0, return null from the method and don't decrement the size field.
            0 -> return null
            2 -> tail = null
        }
        head = head?.nextNode
        // Decrement the size field, but only in case if the size is already bigger than 0.
        size--
        return result
    }

    /**
     * Returns whether or not an element is present in the queue.
     * Returns true if an element is in the queue.
     * Returns false if an element is not present in the queue.
     *
     * contains() iterates through the queue until the current iterated element
     * is null. In this case it returns false.
     * If it finds an element that equals to the parameter passed, it returns true.
     */
    fun contains(element: T): Boolean {
        var currElement: Node<T>? = head
        // Iterate through all elements of the queue until the right element is found
        while (currElement != null) if (currElement.contents == element) return true
        else currElement = head?.nextNode
        // If was not found, return false.
        return false
    }

    /**
     * Returns whether or not the queue is empty.
     * If the size is equal to 0, the queue is empty.
     */
    fun isEmpty() = size == 0

    /**
     * Returns the queue's current size.
     */
    fun size() = size

    /**
     * This class represents a queue node, which has two fields:
     *      contents: T for whatever the node contains inside it.
     *      nextNode: Node<T>? for the next node added after the node.
     */
    inner class Node<T>(val contents: T,
                        var nextNode: Node<T>? = null)
}