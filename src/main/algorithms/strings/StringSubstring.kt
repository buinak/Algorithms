package main.algorithms.strings

import kotlin.test.assertEquals

/**
 * Computes the substring starting at start and ending at endInclusive,
 *      which is the length of text unless specified otherwise.
 */
fun stringSubstring(text: String, start: Int, endInclusive: Int = text.length - 1): String {
    var result = ""
    val startFixed = if (start < 0) 0 else start
    val endFixed = if (endInclusive > text.length - 1) text.length - 1 else endInclusive

    for (i in startFixed..endFixed){
        result += text[i]
        if (i + 1 >= text.length) return result
    }
    return result
}

//Test code to validate the solution.
fun main(args: Array<String>) {
    assertEquals("ego", stringSubstring("category", 3, 5))
    assertEquals("cat", stringSubstring("category", 0, 2))
    assertEquals("category", stringSubstring("category", 0))
}