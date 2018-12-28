package main.algorithms.strings

fun stringLength(text: String): Int {
    var i = 0
    while (true){
        try {
            text[i]
        } catch (exception: IndexOutOfBoundsException){
            return i
        }
        i++
    }
}

fun main(args: Array<String>) {
    println(stringLength("Tuna!"))
}