package main.algorithms.problems

import main.algorithms.searching.binarySearch

/**
 * Methods are assuming the sorted list.
 */


/**
 * O(n^2) worst time complexity
 */
fun findAnyPairProducesSumNaive(t: List<Int>, sum: Int): Pair<Int, Int>{
    t.forEachIndexed { indexA, numberA -> t.forEachIndexed { indexB, numberB ->
        if (indexA != indexB) if (numberA + numberB == sum) return Pair(numberA, numberB)
    } }
    return Pair(-1, -1)
}


/**
 * O(n log n) worst time complexity
 */
fun findAnyPairProducesSumBinarySearch(t: List<Int>, sum: Int): Pair<Int, Int>{
    t.forEachIndexed { index, element ->
        val remainder = sum - element
        val result = binarySearch(t, remainder)
        if (result != -1 && result != index) return when (index > result){
            true -> Pair(t[result], element)
            false -> Pair(element, t[result])
        }
    }
    return Pair(-1, -1)
}

/**
 * O(n) at worst
 */
fun findAnyPairProducesSumLinear(t: List<Int>, sum: Int): Pair<Int, Int>{
    var pointerLeft = 0
    var pointerRight = t.size - 1
    while (pointerLeft < pointerRight){
        val currentSum = t[pointerLeft] + t[pointerRight]
        if (currentSum == sum) return Pair(t[pointerLeft], t[pointerRight])
        when (sum > currentSum){
            true -> pointerLeft++
            false -> pointerRight--
        }
    }
    return Pair(-1, -1)
}



fun main(args: Array<String>) {
    val t = listOf(1, 3, 7, -5, 4, 11, 17, 2).sorted()
    println(findAnyPairProducesSumNaive(t, 8))
    println(findAnyPairProducesSumBinarySearch(t, 8))
    println(findAnyPairProducesSumLinear(t, 8))
}