package main.algorithms.strings

fun stringSubstring(text: String, start: Int, endInclusive: Int = text.length): String {
    var result = ""
    var startFixed = if (start < 0) 0 else start
    for (i in startFixed until endInclusive){
        result += text[i]
        if (i + 1 >= text.length) return result
    }
    return result
}