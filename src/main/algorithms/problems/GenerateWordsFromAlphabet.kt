package main.algorithms.problems

fun generateWordsFixedLength(length: Int, alphabet: List<Char>): List<String> {
    var result = ArrayList<String>()
    for (i in 1..length){
        val current = ArrayList<String>()
        if (result.isEmpty()) {
            for (char in alphabet) result.add("$char")
            continue
        }

        for (string in result) for (char in alphabet)  current.add("$string$char")
        result = current
    }
    return result
}

/**
 * Potentially unoptimised.
 */
fun generateWordsUpperBoundLength(length: Int, alphabet: List<Char>): List<String> {
    var result = ArrayList<String>()
    for (i in 1..length){
        val current = ArrayList<String>()
        if (result.isEmpty()) {
            for (char in alphabet) result.add("$char")
            continue
        }

        for (string in result) for (char in alphabet) {
            "$string$char".run {
                if (this.length == i) current.add(this)
            }
        }

        result.addAll(current)
    }
    return result
}

//TODO: remove this
fun main() {
    generateWordsFixedLength(3, listOf('A', 'b', 'C', 'd')).forEach { println(it) }
    println()
    println()
    generateWordsUpperBoundLength(3, listOf('A', 'b', 'C', 'd')).forEach { println(it) }
}