package main.algorithms.problems.eulerproject

import main.algorithms.mathematics.isPrime

fun largestPrimeFactorSolution(): Int {
    val NUMBER = 600851475143L
    val root = Math.sqrt(NUMBER.toDouble())
    for (i in root.toInt() downTo 1){
        if (NUMBER % i == 0L){
            if (isPrime(i.toLong())) return i
        }
    }
    return 1
}

fun main() {
    println(largestPrimeFactorSolution())
}