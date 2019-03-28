package main.datastructures

import java.util.LinkedList

class HashTable<T> {
    private var innerArray = Array<LinkedList<T>>(16) { LinkedList() }

    fun add(element: T){
        val ind = element.hashCode() % innerArray.size
        innerArray[ind].add(element)
    }

    fun contains(element: T): Boolean{
        val ind = element.hashCode() % innerArray.size
        return innerArray[ind].contains(element)
    }
}


fun main(args: Array<String>) {
    val hsh = HashTable<String>()

    hsh.add("A")
    hsh.add("B")
    hsh.add("Z")

    println("hsh contains \"A\" = ${hsh.contains("A")}")
    println("hsh contains \"Z\" = ${hsh.contains("Z")}")
    println("hsh contains \"C\" = ${hsh.contains("C")}")

}