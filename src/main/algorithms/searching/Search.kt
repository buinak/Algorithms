package main.algorithms.searching

/**
 * Plain list search.
 * Goes through every single element and finds the index of the value by comparing the current element in the loop
 * with the value.
 *
 * Time complexity per case:
 *      Best - O(1), constant. In case the element is on the first place
 *      Average, Worst - O(n), linear.
 */
fun <T> plainSearch(list: List<T>, value: T): Int {
    for (i in 0 until list.size) if (list[i] == value) return i
    return -1
}

/**
 * Binary search, assumes that the list is sorted.
 * Splits the list in half with every single iteration, bringing the worst case running time to O(log n)
 *
 * Time complexity per case:
 *      Best - O(1), constant. In case the element is in the very middle.
 *      Average, Worst - O(log n), logarithmic.
 *
 * @author Konstantin Buinak (https://github.com/buinak)
 */
fun <T : Comparable<T>> binarySearch(list: List<T>, value: T, startIndex: Int = 0, endIndex: Int = list.size - 1): Int {
    if (endIndex >= startIndex) {
        val mid = (startIndex + endIndex) / 2
        when {
            list[mid] == value -> return mid
            list[mid] < value -> return binarySearch(list, value, mid + 1, endIndex)
            list[mid] > value -> return binarySearch(list, value, startIndex, mid - 1)
        }

    }
    return -1
}
