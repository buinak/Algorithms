package main.algorithms.problems.eulerproject

fun sumSquareDifferenceSolution(): Int {
    var sumSquares = 0
    var squareSum = 0
    (1..100).forEach {
        sumSquares += it * it
        squareSum += it
    }
    squareSum *= squareSum
    return Math.abs(sumSquares - squareSum)
}

fun main() {
    println(sumSquareDifferenceSolution())
}