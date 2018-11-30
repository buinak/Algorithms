package main.algorithms.sorting

import main.utils.getStringRepresentation
import main.utils.swap

private fun <T : Comparable<T>> maxHeapify(list: MutableList<T>, index: Int, heapSize: Int) {
    val left = index * 2
    val right = (index * 2) + 1
    var largestIndex: Int = index
    if (left < heapSize && list[left] > list[largestIndex]) largestIndex = left
    if (right < heapSize && list[right] > list[largestIndex]) largestIndex = right
    if (largestIndex != index){
        list.swap(index, largestIndex)
        maxHeapify(list, largestIndex, heapSize)
    }
}

private fun <T: Comparable<T>> buildMaxHeap(list: MutableList<T>){
    var length = list.size / 2
    for (i in length downTo 0) maxHeapify(list, i, list.size)
}

fun <T: Comparable<T>> heapSort(list: MutableList<T>){
    buildMaxHeap(list)
    var heapSize = list.size
    for (i in (list.size - 1) downTo 1){
        list.swap(0, i)
        maxHeapify(list, 0, --heapSize)
    }
}

fun main(args: Array<String>) {
    var list = arrayListOf(2, 8, 1, 14, 7, 9, 3, 10, 4, 16)
    println(list.getStringRepresentation())
    heapSort(list)
    println(list.getStringRepresentation())

}