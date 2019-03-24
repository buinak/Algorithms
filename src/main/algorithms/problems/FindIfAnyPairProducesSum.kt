package main.algorithms.problems

fun findAnyPairProducesSumNaive(t: List<Int>, sum: Int): Pair<Int, Int>{
    t.forEachIndexed { indexA, numberA -> t.forEachIndexed { indexB, numberB ->
        if (indexA != indexB) if (numberA + numberB == sum) return Pair(numberA, numberB)
    } }
    return Pair(-1, -1)
}