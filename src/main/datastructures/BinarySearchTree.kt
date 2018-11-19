package main.datastructures

class BinarySearchTree<T: Comparable<T>> {
    var root: Node<T>? = null

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

    fun depthFirstTraverse(function: (T, Int) -> Unit, node: Node<T>? = root, level: Int = 1){
        if (node != null) function(node.contents, level)
        if (node?.left != null) depthFirstTraverse(function, node.left, level + 1)
        if (node?.right != null) depthFirstTraverse(function, node.right, level + 1)
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
        var currentLevel: Int = 1
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

fun main(args: Array<String>) {
    fun checkTreeContains(tree: BinarySearchTree<Int>, num: Int){
        println("Tree contains element $num = ${tree.contains(num)}")
    }
    val tree = BinarySearchTree<Int>()
    tree.insert(7)
    tree.insert(1)
    tree.insert(15)
    tree.insert(6)
    tree.insert(8)
    tree.insert(3)
    tree.insert(22)
    tree.breadthFirstTraverse{ i -> println("$i at level ${tree.getLevel(i)}")}
}