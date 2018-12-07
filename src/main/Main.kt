package main

import main.algorithms.sorting.*
import main.utils.checkSorted
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) {
    var testList = ArrayList<Int>()
    for (i in 1..100000) {
        testList.add(Random.nextInt(0, 100000100))
    }

    val sortingTimes = ArrayList<SortDataEntity>()
    val sortArray = booleanArrayOf(false, false, false, true, true, true, true, true)

    //bubble sort
    if (sortArray[0]) {
        println("BUBBLE SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val bubbleTime = measureTimeMillis { bubbleSort(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("BUBBLE SORT", bubbleTime))
        val bubbleSortedList = ArrayList(testList)
        bubbleSort(bubbleSortedList)
        bubbleSortedList.checkSorted()
        println("-----------")
    }

    //selection sort
    if (sortArray[1]) {
        println("SELECTION SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val selectionTime = measureTimeMillis { selectionSort(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("SELECTION SORT", selectionTime))
        val selectionSortedList = ArrayList(testList)
        selectionSort(selectionSortedList)
        selectionSortedList.checkSorted()
        println("-----------")
    }

    //insertion sort
    if (sortArray[2]) {
        println("INSERTION SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val insertionTime = measureTimeMillis { insertionSort(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("INSERTION SORT", insertionTime))
        val insertionSortedList = ArrayList(testList)
        insertionSort(insertionSortedList)
        insertionSortedList.checkSorted()
        println("-----------")
    }

    //merge sort
    if (sortArray[3]) {
        println("SENTINEL MERGE SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val mergeTime = measureTimeMillis { mergeSortSentinel(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("SENTINEL MERGE SORT", mergeTime))
        val mergeSortedList = ArrayList(testList)
        mergeSortSentinel(mergeSortedList)
        mergeSortedList.checkSorted()
        println("-----------")
    }

    //quick sort
    if (sortArray[4]) {
        println("QUICK SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val quickTime = measureTimeMillis { quickSort(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("QUICK SORT", quickTime))
        val quickSortedList = ArrayList(testList)
        quickSort(quickSortedList)
        quickSortedList.checkSorted()
        println("-----------")
    }

    //merge-insertion
    if (sortArray[5]) {
        println("MERGE-INSERTION SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val threshold = 4
        val mergeInsertionTime = measureTimeMillis { mergeInsertionSort(tmpArrayList, insertionThreshold = threshold) }.toInt()
        sortingTimes.add(SortDataEntity("MERGE-INSERTION", mergeInsertionTime))
        val mergeInsertionSort = ArrayList(testList)
        mergeInsertionSort(mergeInsertionSort, insertionThreshold = threshold)
        mergeInsertionSort.checkSorted()
        println("-----------")
    }

    //heap
    if (sortArray[6]) {
        println("HEAP SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val heapTime = measureTimeMillis { heapSort(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("HEAP", heapTime))
        val heapSort = ArrayList(testList)
        heapSort(heapSort)
        heapSort.checkSorted()
        println("-----------")
    }
    
    //merge-plain
    if (sortArray[7]) {
        println("PLAIN MERGE SORT sorting..")
        var tmpArrayList = ArrayList(testList)
        val mergeTime = measureTimeMillis { mergeSortPlain(tmpArrayList) }.toInt()
        sortingTimes.add(SortDataEntity("PLAIN MERGE SORT", mergeTime))
        val mergeSortedList = ArrayList(testList)
        mergeSortPlain(mergeSortedList)
        mergeSortedList.checkSorted()
        println("-----------")
    }

    println("Sorting times, from fastest to slowest..")
    sortingTimes.sort()
    sortingTimes.forEach { println("Time to sort a list of ${testList.size} elements using ${it.sortName} = ${it.time} ms") }

    readLine()
}

data class SortDataEntity(val sortName: String, var time: Int) : Comparable<SortDataEntity> {
    override fun compareTo(other: SortDataEntity): Int {
        return when {
            other.time > time -> -1
            other.time < time -> 1
            else -> 0
        }
    }

//    override fun toString(): String {
//        return "main.SortDataEntity(sortName='$sortName', time=$time)"
//    }


}