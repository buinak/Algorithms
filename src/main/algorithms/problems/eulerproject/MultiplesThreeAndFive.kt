package main.algorithms.problems.eulerproject

fun multiplesThreeAndFiveSolution(): Long {
    var sum = 0L
    for (i in 1..999){
        if (i % 3 == 0 || i % 5 == 0) sum += i
    }
    return sum
}

fun main(args: Array<String>) {
    println(multiplesThreeAndFiveSolution()) // Result: 233168
}