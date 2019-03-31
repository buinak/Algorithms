package main.datastructures

import java.util.LinkedList
import kotlin.random.Random

class HashSet<T> {
    private val INITIAL_SIZE = 16
    private val LOAD_FACTOR = 1

    private var currentSize = 16
    private var freeLists = 16

    private var innerArray = Array<LinkedList<T>>(16) { LinkedList() }


    fun add(element: T){
        val ind = element.hashCode() % innerArray.size
        if (innerArray[ind].isEmpty()) freeLists--
        innerArray[ind].add(element)
        if (freeLists == 0){
            rebalance()
        }
    }

    fun contains(element: T): Boolean{
        val ind = element.hashCode() % innerArray.size
        return innerArray[ind].contains(element)
    }

    private fun rebalance(){
        val elementsList = LinkedList<T>()
        for (i in 0 until currentSize){
            elementsList.addAll(innerArray[i])
        }
        currentSize *= 2
        freeLists = currentSize
        innerArray = Array(currentSize) { LinkedList<T>() }
        for (element in elementsList){
            val ind = element.hashCode() % innerArray.size
            if (innerArray[ind].isEmpty()) freeLists--
            innerArray[ind].add(element)
        }
    }


}


fun main(args: Array<String>) {
    fun testAdditionAndLookup(){
        val hsh = HashSet<String>()

        hsh.add("A")
        hsh.add("B")
        hsh.add("Z")

        println("hsh contains \"A\" = ${hsh.contains("A")}")
        println("hsh contains \"Z\" = ${hsh.contains("Z")}")
        println("hsh contains \"C\" = ${hsh.contains("C")}")
    }
    fun testRebalancing(){
        val alphabet = listOf(
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',
            'z')
        val hsh = HashSet<String>()

        for (i in 1..50){
            var str = ""
            for (j in 1..4){
                val rnd = Random.nextInt(0, alphabet.size)
                str += alphabet[rnd]
            }
            hsh.add(str)
        }
    }

    testAdditionAndLookup()
    testRebalancing()


}