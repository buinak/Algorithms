package main.datastructures

import kotlin.random.Random

class BinarySearchTree<T: Comparable<T>> {
    private var root: Node<T>? = null

    fun insert(element: T, node: Node<T>? = root){
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

    fun contains(element: T, node: Node<T>? = root): Boolean {
        if (node == null) return false
        if (node.contents == element) return true
        return if (element > node.contents) contains(element, node.right) else contains(element, node.left)
    }

    fun depthFirstTraverseWithLevel(function: (T, Int) -> Unit, node: Node<T>? = root, level: Int = 1){
        if (node == null) return
        if (node.left != null) depthFirstTraverseWithLevel(function, node.left, level + 1)
        function(node.contents, level)
        if (node.right != null) depthFirstTraverseWithLevel(function, node.right, level + 1)
    }

    fun depthFirstTraverse(function: (T) -> Unit, node: Node<T>? = root){
        if (node == null) return
        if (node.left != null) depthFirstTraverse(function, node.left)
        function(node.contents)
        if (node.right != null) depthFirstTraverse(function, node.right)
    }

    fun breadthFirstTraverse(function: (T) -> Unit){
        val queue = Queue<Node<T>>()
        if (root == null) return

        val rootNode = root as Node<T>
        queue.enqueue(rootNode)
        while (!queue.isEmpty()){
            val currNode: Node<T> = queue.dequeue() ?: continue
            function(currNode.contents)
            if (currNode.left != null) queue.enqueue(currNode.left!!)
            if (currNode.right != null) queue.enqueue(currNode.right!!)
        }
    }

    fun getLevel(element: T): Int{
        if (!contains(element)) return -1
        var currentLevel = 1
        var currentNode = root as Node<T>
        while (currentNode.contents != element){
            currentLevel++
            currentNode = if (element > currentNode.contents) currentNode.right!! else currentNode.left!!
        }
        return currentLevel
    }


    inner class Node<T: Comparable<T>>(var contents: T){
        var left: Node<T>? = null
        var right: Node<T>? = null
    }
}