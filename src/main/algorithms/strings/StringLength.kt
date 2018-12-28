package main.algorithms.strings

fun stringLength(text: String): Int {
    var i = 0
    while (true){
        var currChar: Char
        try {
            currChar = text[i]
        } catch (exception: IndexOutOfBoundsException){
            return i
        }
        i++
    }
}