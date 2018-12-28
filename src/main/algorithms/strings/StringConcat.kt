package main.algorithms.strings

fun stringConcatenate(first: String, second: String): String {
    var result = ""
    for (i in 0 until first.length) result += first[i]
    for (i in 0 until second.length) result += second[i]
    return result
}