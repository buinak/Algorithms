package main.algorithms.mathematics

fun findFibonacciRecursive(n: Int, prev: Long = 1, current: Long = 1): Long{
    if (n <= 2) return current
    else return findFibonacciRecursive(n - 1, current, prev + current)
}

fun findFibonacciIterative(n: Int): Long{
    if (n <= 2) return 1
    var previous = 1L
    var current = 1L
    for (i in 2 until n){
        val tmp = current
        current += previous
        previous = tmp
    }
    return current
}

fun findFibonacciRecursiveExponential(n: Int): Long {
    return when (n <= 2){
        true -> 1
        else -> findFibonacciRecursiveExponential(n - 1) + findFibonacciRecursiveExponential(n - 2)
    }
}
