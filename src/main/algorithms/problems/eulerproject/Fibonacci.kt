package main.algorithms.problems.eulerproject

fun evenFibonacciSolution(): Long {
    var current = 1
    var previous = 1
    var sum = 0L
    while (true){
        if (current > 4000000) return sum
        if (current % 2 == 0) sum += current
        val tmp = current
        current += previous
        previous = tmp
    }
}

fun main(args: Array<String>) {
    println(evenFibonacciSolution()) // Result: 4613732
}