package main.debug

import main.algorithms.sorting.mergeInsertionSort
import main.algorithms.sorting.mergeSortPlain
import main.algorithms.sorting.mergeSortSentinel
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    var statsMap = ArrayList<SortDataEntity>()
    var plainMergeSort = SortDataEntity("PLAIN MERGE SORT", 0)
    var sentinelMergeSort = SortDataEntity("SENTINEL MERGE SORT", 0)
    var mergeInsertionSortData = SortDataEntity("MERGE INSERTION SORT", 0)
    var quickSort = SortDataEntity("QUICK SORT", 0)
    var heapSort = SortDataEntity("HEAP SORT", 0)
    statsMap.add(plainMergeSort)
    statsMap.add(sentinelMergeSort)
    statsMap.add(mergeInsertionSortData)
    statsMap.add(quickSort)
    statsMap.add(heapSort)
    var n = 1000000
    var times = 50
    var i = 1
    for (i in 1..times){
        println("$i out of ${times} done")
        var list = ArrayList<Int>()
        for (j in 1..Random.nextInt(100000, n)) list.add(Random.nextInt(1, 1234567890))
        var plainList = ArrayList<Int>(list)
        var sentList = ArrayList<Int>(list)
        var inseList = ArrayList<Int>(list)
        var quickList = ArrayList<Int>(list)
        var heapList = ArrayList<Int>(list)
        plainMergeSort.time += measureTimeMillis { mergeSortPlain(plainList) }.toInt()
        sentinelMergeSort.time += measureTimeMillis { mergeSortSentinel(sentList) }.toInt()
        mergeInsertionSortData.time += measureTimeMillis { mergeInsertionSort(inseList, 8) }.toInt()
        quickSort.time += measureTimeMillis { main.algorithms.sorting.quickSort(quickList) }.toInt()
        heapSort.time += measureTimeMillis { main.algorithms.sorting.heapSort(heapList) }.toInt()
    }

    statsMap.sorted().forEach { println("$n elements with ${it.sortName} = ${it.time / times}ms") }
}