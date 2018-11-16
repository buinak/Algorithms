package utils

import algorithms.searching.binarySearch


fun <T> MutableList<T>.swap(indexFirst: Int, indexSecond: Int){
    val tmp = this[indexFirst]
    this[indexFirst] = this[indexSecond]
    this[indexSecond] = tmp
}

fun <T> List<T>.getString(): String {
    if (size > 10000) return " The list is too long to output!"
    var string = ""
    forEach { string += "$it, " }
    string = string.trimEnd(' ')
    string = string.trimEnd(',')
    return string
}

fun <T : Comparable<T>> List<T>.checkSorted() {
    if (this != this.sorted()) println("Unsorted, quitting..").also { return }
}


fun List<Int>.checkSearching(){
    forEachIndexed { index, element -> if (binarySearch(this, element) != index) println("Binary search failed for $element at $index, returned ${binarySearch(this, element)}!")
        .also { Runtime.getRuntime().exit(-11) }  }
    println("Binary search works properly!")
}