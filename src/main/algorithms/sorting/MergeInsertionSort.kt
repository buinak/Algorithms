package main.algorithms.sorting

import main.debug.SortDataEntity
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * Merge-Insertion sort is a sorting algorithm using the principle that for
 * smaller sets of data, insertion sort is more efficient than merge sort.
 * It uses a threshold. If the list's size is below the threshold, insertion sort will be used.
 *
 * Principle:
 *      Use insertion sort for smaller lists below the threshold size, otherwise
 *      use merge sort.
 *
 * Time complexity: O(n log n) on average.
 *
 * Space complexity: O(n) auxiliary for merging.
 */
fun mergeInsertionSort(list: MutableList<Int>, insertionThreshold: Int = 8){
    mergeInsertionSort(list, 0, list.size - 1, insertionThreshold)
}

private fun mergeInsertionSort(list: MutableList<Int>, start: Int, end: Int, insertionThreshold: Int = 8) {
    if (end > start) {
        if ((end - start) > insertionThreshold) {
            val mid = (end + start) / 2
            mergeInsertionSort(list, start, mid)
            mergeInsertionSort(list, mid + 1, end)
            merge(list, start, mid, end)
        } else {
            insertionSort(list, start, end)
        }
    }
}


private fun <T : Comparable<T>> insertionSort(list: MutableList<T>, start: Int = 0, end: Int = list.size) {
    for (j in (start + 1)..end) {
        val key = list[j]
        var i = j - 1
        while (i >= start && list[i] > key) {
            list[i + 1] = list[i]
            i -= 1
        }
        list[i + 1] = key
    }
}

private fun merge(list: MutableList<Int>, start: Int, mid: Int, end: Int) {
    val numLeft = mid - start + 1
    val numRight = end - mid
    val leftArray = IntArray(numLeft + 1)
    val rightArray = IntArray(numRight + 1)
    for (i in 1..numLeft) {
        leftArray[i - 1] = list[start + i - 1]
    }
    for (i in 1..numRight) {
        rightArray[i - 1] = list[mid + i]
    }
    leftArray[numLeft] = Int.MAX_VALUE
    rightArray[numRight] = Int.MAX_VALUE
    var i = 0
    var j = 0
    for (k in start..end) {
        list[k] = if (leftArray[i] < rightArray[j]) leftArray[i++] else rightArray[j++]
    }
}

fun main(args: Array<String>) {
    var averageSentinel = 0L
    var averagePlain = 0L
    var averageQuick = 0L
    val averageInsertionMap = HashMap<Int, Long>()
    for (i in 2..16) averageInsertionMap[i] = 0L

    val n = 10
    val listSize = 20000000
    for (i in 1..n) {
        var testList = ArrayList<Int>()
        for (j in 1..listSize) {
            testList.add(Random.nextInt(0, 100000100))
        }
        var list1 = ArrayList(testList)
        var list3 = ArrayList(testList)
        var list4 = ArrayList(testList)
        averageSentinel += measureTimeMillis { mergeSortSentinel(list1) }
        averagePlain += measureTimeMillis { mergeSortSentinel(list3) }
        averageQuick += measureTimeMillis { quickSort(list4) }
        for (entry in averageInsertionMap) {
            var list2 = ArrayList(testList)
            entry.setValue(entry.value + measureTimeMillis {
                mergeInsertionSort(list2, insertionThreshold = entry.key)
            })
        }
        println("Done $i out of $n")
    }
    averageSentinel /= n
    averagePlain /= n
    averageQuick /= n
    println("Data size = $n random lists of $listSize elements each")
    val list = ArrayList<SortDataEntity>()
    println("Average time per sort in milliseconds (ms): ")
    for (entry in averageInsertionMap) {
        list.add(
            SortDataEntity(
                "InsertionMergeSort with Threshold ${entry.key}",
                ((entry.value / n).toInt())
            )
        )
    }
    list.add(SortDataEntity("SentinelMergeSort", averageSentinel.toInt()))
    list.add(SortDataEntity("PlainMergeSort", averagePlain.toInt()))
    list.add(SortDataEntity("QuickSort", averageQuick.toInt()))
    list.sort()
    for (sortData in list) {
        println(sortData)
    }
}