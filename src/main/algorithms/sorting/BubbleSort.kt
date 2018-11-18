package main.algorithms.sorting

import main.utils.swap

/**
 * Bubble sort, also sometimes referred to as Sinking sort, is a rather simple algorithms.sorting algorithm.
 * Principle: iteratively go through the list and swap adjacent elements which are not placed in the correct order.
 *
 *
 * Despite the advantages of simplicity, the average time complexity of O(n^2) makes the algorithm impractical for usage
 * in any production-grade applications with any relatively sizeable data set for sorting.
 * Bubble sort's advantages are the low usage of memory (O(1) auxiliary for the variable to track swapping) and
 * the O(n) complexity for almost sorted lists. Compared to, for instance, merge sort with its best case O(n log n)
 * complexity, bubble sort would win for small sets of data.
 *
 * Time complexity: Best case: O(n) for an almost sorted list. Average/Worst case: O(n^2)
 * Space complexity: O(1) auxiliary
 *
 * @author Konstantin Buinak (https://github.com/buinak)
 */
fun <T : Comparable<T>> bubbleSort(list: MutableList<T>) {
    var swapped: Boolean
    do {
        swapped = false
        for (i in 0 until list.size - 1) {
            if (list[i] > list[i + 1]) {
                list.swap(i, i + 1)
                swapped = true
            }
        }
    } while (swapped)
}