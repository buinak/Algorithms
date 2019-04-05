package main.datastructures.lists

/**
 * A basic Stack implementation using linked nodes.
 * A Stack is a data structure that implements the First In - Last Out principle.
 *
 * Time complexity for pushing and popping elements in a stack is that of a queue-
 * O(1) for both popping and pushing.
 *
 * Likewise, using linked nodes comes with a certain memory penalty as pointers to
 * all the nodes have to be stored, but has the advantage of its very simple implementation.
 * Furthermore, using linked nodes means improved time complexity - the O(1) time
 * complexity for pushing would be amortized due to having to re-create the array
 * in case if the array behind it is not sufficient to fit in an extra element.
 *
 * Time complexity:
 *      O(1) push()
 *      O(1) pop()
 *      O(n) contains()
 *      Thus making it a very efficient data structure.
 */
class Stack<T> {
    // The head of the stack is the element of top of it. It is the first to be popped.
    private var head: Node<T>? = null
    // The size of the stack.
    private var size = 0

    /**
     * Pushes an element on top of the stack.
     * There are two cases to cover:
     *      The stack is empty, assign the head to be equal to the element pushed.
     *      The stack is not empty, in which case the head is assigned to be equal
     *          to the element pushed and has the old head linked to it.
     */
    fun push(element: T) {
        head = when (head == null){
            true -> Node(element)
            else -> Node(element, head)
            // Increment the size.
        }.also { size++ }
    }

    /**
     * Pops an element from the top of the stack.
     * pop() assigns the head to be equal to the node linked to the current head
     *      and then returns the old head.
     */
    fun pop(): T? {
        /* If there are no elements in the stack, return null.
           Otherwise decrement the size.
         */
        if (size == 0) return null else size--
        return head?.contents
                .also { head = head?.nextNode }
    }

    /**
     * Returns whether or not an element is present in the stack.
     * Returns true if an element is in the stack.
     * Returns false if an element is not present in the stack.
     *
     * contains() iterates through the queue until the current iterated element
     * is null. In this case it returns false.
     * If it finds an element that equals to the parameter passed, it returns true.
     */
    fun contains(element: T): Boolean {
        var currElement: Node<T>? = head
        // Iterate through all elements of the queue until the right element is found
        while (currElement != null) if (currElement.contents == element) return true
        else currElement = currElement.nextNode
        // If was not found, return false.
        return false
    }

    /**
     * Returns true/false on whether the stack is empty.
     * If the stack is empty, the Size field is 0.
     */
    fun isEmpty(): Boolean = size == 0

    /**
     * Returns the current size of the stack.
     */
    fun size() = size

    /**
     * This class represents a stack node, which has two fields:
     *      contents: T for whatever the node contains inside it.
     *      nextNode: Node<T>? for the next node added after the node.
     */
    inner class Node<T>(val contents: T, var nextNode: Node<T>? = null)
}