package utils

import algorithms.searching.binarySearch

/**
 * Swaps two elements at indexes i, j in a list.
 * Given two indexes I and J, swapping is process which would produce the origin list with the element originally
 * being at index I now being at index J and the element originally being at index J now being at index I
 * @author Konstantin Buinak (https://github.com/buinak)
 */
fun <T> MutableList<T>.swap(indexFirst: Int, indexSecond: Int) {
    val tmp = this[indexFirst]
    this[indexFirst] = this[indexSecond]
    this[indexSecond] = tmp
}

fun <T> List<T>.getStringRepresentation(maxElements: Int): String {
    if (size > maxElements) return " The list is too long to output!"
    var string = ""
    forEach { string += "$it, " }
    string = string.trimEnd(' ')
    string = string.trimEnd(',')
    return string
}

fun <T: Comparable<T>> List<T>.checkSorted(): Boolean {
    return this == this.sorted()
}

fun List<Int>.isBinarySearcheable(): Boolean {
    return (this == this.distinct().sorted())
}