package main.datastructures

import kotlin.random.Random

class RedBlackTree<T : Comparable<T>> {

    var root: Node<T>? = null

    fun insert(element: T) {
        var father: Node<T>? = null
        var current: Node<T>? = root
        while (current != null) {
            father = current
            when {
                element < current.contents -> current = current.left
                element > current.contents -> current = current.right
                element == current.contents -> return
            }
        }
        if (father == null) {
            root = Node(element, father, true)
            return
        }
        if (element < father.contents) {
            father.left = Node(element, father, false)
            insertFixup(father.left)
        } else {
            father.right = Node(element, father, false)
            insertFixup(father.right)
        }
    }

    private fun insertFixup(node: Node<T>?) {
        var uncle: Node<T>?
        var current: Node<T>? = node

        while (current?.parent?.colorBlack == false) {
            if (current.parent == current.parent?.parent?.left) {
                uncle = current.parent?.parent?.right
                when {
                    uncle?.colorBlack == false -> {
                        current.parent?.colorBlack = true
                        uncle.colorBlack = true
                        current.parent?.parent?.colorBlack = false
                        current = current.parent?.parent
                    }
                    current == current.parent?.right -> {
                        current = current.parent
                        if (current!!.parent?.parent == null) root = current.parent
                        current.rotateLeft()
                    }
                    current == current.parent?.left -> {
                        if (current.parent?.parent?.parent == null) root = current.parent
                        current.parent?.parent?.rotateRight()
                    }
                }
            } else {
                uncle = current.parent?.parent?.left
                when {
                    uncle?.colorBlack == false -> {
                        current.parent?.colorBlack = true
                        uncle.colorBlack = true
                        current.parent?.parent?.colorBlack = false
                        current = current.parent?.parent
                    }

                    current == current.parent?.left -> {
                        current = current.parent
                        if (current!!.parent?.parent == null) root = current.parent
                        current.rotateRight()
                    }

                    current == current.parent?.right -> {
                        if (current.parent?.parent?.parent == null) root = current.parent
                        current.parent?.parent?.rotateLeft()
                    }
                }
            }
        }
        root?.colorBlack = true
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

    fun contains(element: T, node: Node<T>? = root): Boolean {
        if (node == null) return false
        if (node.contents == element) return true
        return if (element > node.contents) contains(element, node.right) else contains(element, node.left)
    }

    inner class Node<T : Comparable<T>>(var contents: T, var parent: Node<T>? = null, var colorBlack: Boolean = false) {
        var left: Node<T>? = null
        var right: Node<T>? = null

        fun isLeaf(): Boolean = (this.left == null) && (this.right == null)

        fun brother(): Node<T>? {
            if (this == this.parent?.left)
                return this.parent!!.right

            return this.parent?.left
        }

        fun rotateLeft() {
            val rightChild = this.right ?: return
            val dad = this.parent

            this.swapColors(rightChild)
            rightChild.left?.parent = this
            this.right = rightChild.left
            rightChild.left = this

            when {
                this == dad?.left -> dad.left = rightChild
                this == dad?.right -> dad.right = rightChild
            }

            this.parent = rightChild
            rightChild.parent = dad
        }

        fun rotateRight() {
            val leftChild = this.left ?: return
            val dad = this.parent

            this.swapColors(leftChild)
            leftChild.right?.parent = this
            this.left = leftChild.right
            leftChild.right = this

            when {
                this == dad?.left -> dad.left = leftChild
                this == dad?.right -> dad.right = leftChild
            }

            this.parent = leftChild
            leftChild.parent = dad
        }

        private fun swapColors(node2: Node<T>?) {
            val node1color = this.colorBlack

            if (node2 != null) {
                this.colorBlack = node2.colorBlack
                node2.colorBlack = node1color
            }
        }
    }
}

fun main(args: Array<String>) {
    val tree = RedBlackTree<Int>()
    for (i in 1..7){
        tree.insert(Random.nextInt(1, 123))
    }
    tree.orderedTraverse { str -> print("$str, ") }
}