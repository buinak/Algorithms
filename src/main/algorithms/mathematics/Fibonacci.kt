package main.algorithms.mathematics

fun findFibonacciRecursive(n: Int, prev: Long = 1, current: Long = 1): Long{
    if (n <= 2) return current
    else return findFibonacciRecursive(n - 1, current, prev + current)
}