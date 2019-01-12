package main.algorithms.strings

fun stringConcatenate(first: String, second: String): String {
    var result = ""
    for (i in 0 until first.length) result += first[i]
    for (i in 0 until second.length) result += second[i]
    return result
}

fun stringConcatenateArrays(first: List<Char>, second: List<Char>): List<Char> {
    var result = ArrayList<Char>(first.size + second.size)
    var j = 0
    for (i in 0 until first.size) i.run {
        result[this] = first[this]
        j = this
    }
    for (k in 0 until second.size) result[k + j + 1] = second[k]
    return result
}