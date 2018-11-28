package main.algorithms.sorting

/**
 * Bogo sort is a very inefficient sorting algorithm.
 * Principle:
 *      Shuffle the list until it is sorted.
 *
 * Time complexity: O((n+1)!) on average.
 * Space complexity:
 *
 *
 * @author Konstantin Buinak (https://github.com/buinak)
 */
fun <T: Comparable<T>> bogoSort(list: MutableList<T>) {
    fun isSorted(list: List<T>): Boolean {
        var sorted = true
        for (i in 1 until list.size) {
            if (list[i - 1] > list[i]) sorted = false
        }
        return sorted
    }

    while (!isSorted(list)) {
        list.shuffle()
    }
}