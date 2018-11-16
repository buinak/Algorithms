package sorting

import swap

/**
 * Bubble sort, also sometimes referred to as Sinking sort, is a rather simple sorting algorithm.
 * Principle: go through the list and repeatedly swap elements in a certain order.
 *
 * Despite the advantages of simplicity, the average time complexity of O(n^2) makes the algorithm impractical for usage
 * in any production applications.
 *
 * Time complexity: Best case: O(n) for an almost sorted list. Average/Worst case: O(n^2)
 * Space complexity: O(1) auxiliary
 */
class BubbleSort (list: MutableList<Int>) {
    init {
        var swapped: Boolean
        do {
            swapped = false
            for (i in 0 until list.size - 1){
                if (list[i] > list[i + 1]){
                    list.swap(i, i + 1)
                    swapped = true
                }
            }
        } while (swapped)
    }

}