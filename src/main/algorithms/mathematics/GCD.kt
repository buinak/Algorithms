package main.algorithms.mathematics

fun findGreatestCommonDivisor(first: Long, second: Long): Long {
    val smaller = if (first <= second) first else second
    val bigger = if (first > second) first else second

    return if (bigger % smaller == 0L) smaller
    else findGreatestCommonDivisor(smaller, bigger % smaller)
}