import algorithms.sorting.*
import statistics.SortDataEntity
import utils.checkSearching
import utils.checkSorted
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) {
    var testList = ArrayList<Int>()
    for (i in 1..25000) {
        testList.add(Random.nextInt(0, 100000100))
    }
    testList
        .sorted()
        .distinct()
        .checkSearching()

    val sortingTimes = TreeSet<SortDataEntity>()
    val sortArray = booleanArrayOf(true, true, true, true, true)

    //bubble sort
    if (sortArray[0]) {
        println("BUBBLE SORT algorithms.sorting..")
        val bubbleTime = measureTimeMillis { bubbleSort(ArrayList(testList)) }.toInt()
        sortingTimes.add(SortDataEntity("BUBBLE SORT", bubbleTime))
        val bubbleSortedList = ArrayList(testList)
        bubbleSort(bubbleSortedList)
        bubbleSortedList.checkSorted()
        println("-----------")
    }

    //selection sort
    if (sortArray[1]) {
        println("SELECTION SORT algorithms.sorting..")
        val selectionTime = measureTimeMillis { selectionSort(ArrayList(testList)) }.toInt()
        sortingTimes.add(SortDataEntity("SELECTION SORT", selectionTime))
        val selectionSortedList = ArrayList(testList)
        selectionSort(selectionSortedList)
        selectionSortedList.checkSorted()
        println("-----------")
    }

    //insertion sort
    if (sortArray[2]) {
        println("INSERTION SORT algorithms.sorting..")
        val insertionTime = measureTimeMillis { insertionSort(ArrayList(testList)) }.toInt()
        sortingTimes.add(SortDataEntity("INSERTION SORT", insertionTime))
        val insertionSortedList = ArrayList(testList)
        insertionSort(insertionSortedList)
        insertionSortedList.checkSorted()
        println("-----------")
    }

    //merge sort
    if (sortArray[3]) {
        println("MERGE SORT algorithms.sorting..")
        val mergeTime = measureTimeMillis { mergeSortSentinel(ArrayList(testList)) }.toInt()
        sortingTimes.add(SortDataEntity("MERGE SORT", mergeTime))
        val mergeSortedList = ArrayList(testList)
        mergeSortSentinel(mergeSortedList)
        mergeSortedList.checkSorted()
        println("-----------")
    }

    //quick sort
    if (sortArray[4]) {
        println("QUICK SORT algorithms.sorting..")
        val quickTime = measureTimeMillis { quicksort(ArrayList(testList)) }.toInt()
        sortingTimes.add(SortDataEntity("QUICK SORT", quickTime))
        val quickSortedList = ArrayList(testList)
        quicksort(quickSortedList)
        quickSortedList.checkSorted()
        println("-----------")
    }

    println("Sorting times, from fastest to slowest..")
    sortingTimes.forEach { println("Time to sort a list of ${testList.size} elements using ${it.sortName} = ${it.time} ms") }

    readLine()
}
