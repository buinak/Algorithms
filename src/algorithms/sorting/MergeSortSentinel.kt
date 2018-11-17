package algorithms.sorting

/**
 * Merge Sort using Sentinels - Int.MAX_VALUE entries when merging lists.
 * Allows to eliminate checks for whether the left/right list are fully added to the original list.
 * Performs better than plain merge sort at the cost of extra O(2 (log N)) auxiliary memory.
 *
 * Time complexity per case:
 *      Best, Average, Worst - O(n log n), logarithmic.
 *
 * Space complexity:
 *      Auxiliary O(n) memory.
 *
 * @author Konstantin Buinak (https://github.com/buinak)
 */

fun mergeSortSentinel(list: MutableList<Int>, start: Int = 0, end: Int = list.size - 1) {
    if (end > start) {
        val mid = (end + start) / 2
        mergeSortSentinel(list, start, mid)
        mergeSortSentinel(list, mid + 1, end)
        merge(list, start, mid, end)
    }
}

private fun merge(list: MutableList<Int>, start: Int, mid: Int, end: Int) {
    val numLeft = mid - start + 1
    val numRight = end - mid
    val leftArr = IntArray(numLeft + 1)
    val rightArr = IntArray(numRight + 1)
    for (i in 1..numLeft) {
        leftArr[i - 1] = list[start + i - 1]
    }
    for (i in 1..numRight) {
        rightArr[i - 1] = list[mid + i]
    }
    leftArr[numLeft] = Int.MAX_VALUE
    rightArr[numRight] = Int.MAX_VALUE
    var i = 0
    var j = 0
    for (k in start..end) {
        list[k] = if (leftArr[i] < rightArr[j]) leftArr[i++] else rightArr[j++]
    }

}
