package main.algorithms.sorting

/**
 * Very inefficient. O((n+1)!)
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