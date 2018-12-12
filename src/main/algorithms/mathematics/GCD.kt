package main.algorithms.mathematics

fun greatestCommonDivisor(first: Long, second: Long): Long {
    var smaller = if (first <= second) first else second
    var bigger = if (first > second) first else second

    return if (bigger % smaller == 0L) smaller
    else greatestCommonDivisor(smaller, bigger % smaller)
}