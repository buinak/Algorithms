package main.datastructures


class BinarySearchTree<T : Comparable<T>> {
    private var root: Node<T>? = null

    fun insert(element: T, node: Node<T>? = root) {
        if (node == null) {
            root = Node(element)
            return
        }
        when {
            element > node.contents -> if (node.right == null) {
                node.right = Node(element)
            } else {
                insert(element, node.right)
            }
            element < node.contents -> if (node.left == null) {
                node.left = Node(element)
            } else {
                insert(element, node.left)
            }
        }
    }

    fun delete(element: T) {
        if (root == null) return else {
            val currentRoot = root as Node<T>
            if (currentRoot.contents == element) {
                when (currentRoot.countChildren()) {
                    0 -> root = null
                    1 -> root = if (currentRoot.left != null) currentRoot.left else currentRoot.right
                    2 -> {
                        val minimumValue = currentRoot.right!!.minimumValue()
                        currentRoot.right!!.removeChild(minimumValue, currentRoot)
                        currentRoot.contents = minimumValue
                    }
                }
            } else {
                currentRoot.removeChild(element)
            }

        }
    }

    fun contains(element: T, node: Node<T>? = root): Boolean {
        if (node == null) return false
        if (node.contents == element) return true
        return if (element > node.contents) contains(element, node.right) else contains(element, node.left)
    }

    fun orderedTraverseWithLevel(function: (T, Int) -> Unit) {
        if (root == null) return
        orderedTraverseWithLevel(function, root!!, 1)
    }

    private fun orderedTraverseWithLevel(function: (T, Int) -> Unit, node: Node<T>, level: Int = 1) {
        if (node.left != null) orderedTraverseWithLevel(function, node.left!!, level + 1)
        function(node.contents, level)
        if (node.right != null) orderedTraverseWithLevel(function, node.right!!, level + 1)
    }

    fun orderedTraverse(function: (T) -> Unit) {
        if (root == null) return
        orderedTraverse(function, root!!)
    }

    private fun orderedTraverse(function: (T) -> Unit, node: Node<T>) {
        if (node.left != null) orderedTraverse(function, node.left!!)
        function(node.contents)
        if (node.right != null) orderedTraverse(function, node.right!!)
    }

    fun breadthFirstTraverse(function: (T) -> Unit) {
        val queue = Queue<Node<T>>()
        if (root == null) return

        val rootNode = root as Node<T>
        queue.enqueue(rootNode)
        while (!queue.isEmpty()) {
            val currNode: Node<T> = queue.dequeue() ?: continue
            function(currNode.contents)
            if (currNode.left != null) queue.enqueue(currNode.left!!)
            if (currNode.right != null) queue.enqueue(currNode.right!!)
        }
    }

    fun getLevel(element: T): Int {
        if (!contains(element)) return -1
        var currentLevel = 1
        var currentNode = root as Node<T>
        while (currentNode.contents != element) {
            currentLevel++
            currentNode = if (element > currentNode.contents) currentNode.right!! else currentNode.left!!
        }
        return currentLevel
    }


    fun getMinimum(): T? {
        val root: Node<T>? = root ?: return null
        if (root!!.left == null) return root.contents

        var currElement = root
        while (currElement?.left != null) {
            currElement = currElement.left
        }

        return currElement!!.contents
    }

    inner class Node<T : Comparable<T>>(var contents: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null

        //If there is no parent node, it is not going to be used.
        //To avoid null-related errors, in case if it is not passed we put a placeholder node inside of it.
        fun removeChild(value: T, parentNode: Node<T> = Node(value)) {
            val left = left
            val right = right

            if (value < this.contents) {
                left?.removeChild(value, this)
            } else if (value > this.contents) {
                right?.removeChild(value, this)
            } else {
                if (left != null && right != null) {
                    this.contents = right.minimumValue()
                    right.removeChild(this.contents, this)
                } else if (parentNode.left == this) {
                    parentNode.left = left ?: right
                } else if (parentNode.right == this) {
                    parentNode.right = left ?: right
                }
            }
        }

        fun countChildren(): Int {
            var count = 0
            if (left != null) count++
            if (right != null) count++
            return count
        }

        fun minimumValue(): T = when (left) {
            null -> contents
            else -> left!!.minimumValue()
        }


        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Node<*>

            if (contents != other.contents) return false

            return true
        }

        override fun hashCode(): Int {
            return contents.hashCode()
        }
    }
}