package main.algorithms.strings

import kotlin.test.assertEquals

fun stringSearch(text: String, pattern: String): Int {
    //if the searched text is longer than the original
    if (pattern.length > text.length) return -1
    //if the searched text is null
    if (pattern.isEmpty()) return 0

    for (i in 0 until text.length - pattern.length){
        var j = i
        while (text[j] == pattern[j - i]){
            if ((j - i) + 1 == pattern.length) return i
            if (j + 1 == text.length) break
            j++
        }
    }
    return -1
}

//Test code to validate the solution.
fun main(args: Array<String>) {
    assertEquals(3, stringSearch("category", "ego"))
    assertEquals(0, stringSearch("category", ""))
    assertEquals(-1, stringSearch("category", "egoegoegoego"))
}