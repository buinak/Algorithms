package main.algorithms.strings

fun stringSearch(text: String, pattern: String): Int {
    //if the searched text is longer than the original
    if (pattern.length > text.length) return -1
    //if the searched text is null
    if (pattern.length == 0) return 0

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