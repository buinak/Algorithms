package main.algorithms.strings

fun stringSubstring(text: String, start: Int, endInclusive: Int = text.length): String {
    var result = ""
    for (i in start until endInclusive){
        result += text[i]
        if (i + 1 >= text.length) return result
    }
    return result
}