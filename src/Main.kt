import collections.LinkedList
import searching.BinarySearch
import sorting.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.measureTimeMillis

fun <T> List<T>.getString(): String {
    if (size > 10000) return " The list is too long to output!"
    var string = ""
    forEach { string += "$it, " }
    string = string.trimEnd(' ')
    string = string.trimEnd(',')
    return string
}

fun <T : Comparable<T>> List<T>.checkSorted() {
    if (this != this.sorted()) println("Unsorted, quitting..").also { return }
}

fun checkSearching(list: List<Int>){
    list.forEachIndexed { index, element -> if (BinarySearch.search(list, element) != index) println("Binary search failed for $element at $index, returned ${BinarySearch.search(list, element)}!")
        .also { Runtime.getRuntime().exit(-11) }  }
    println("Binary search works properly!")
}

fun getRandom(lowerBound: Int, upperBound: Int) = Random().nextInt(upperBound - lowerBound) + lowerBound

fun getRandom(upperBound: Int) = Random().nextInt(upperBound)



fun main(args: Array<String>) {
    var testList = ArrayList<Int>()
    for (i in 1..100000) {
        testList.add(getRandom(1, 2770))
    }
    checkSearching(testList.sorted().distinct())
    val sortingTimes = TreeMap<Int, String>()

    println("Bubble sort")
    val bubbleTime = measureTimeMillis { BubbleSort(ArrayList(testList)) }.toInt()
    sortingTimes[bubbleTime] = "BUBBLE SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val bubbleSortedList = ArrayList(testList)
    BubbleSort(bubbleSortedList)
    bubbleSortedList.checkSorted()
    print(bubbleSortedList.getString()).also { println() }
    println("-----------")

    println("Selection sort")
    val selectionTime = measureTimeMillis { SelectionSort(ArrayList(testList)) }.toInt()
    sortingTimes[selectionTime] = "SELECTION SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val selectionSortedList = ArrayList(testList)
    SelectionSort(selectionSortedList)
    selectionSortedList.checkSorted()
    print(selectionSortedList.getString()).also { println() }
    println("-----------")

    println("Insertion sort")
    val insertionTime = measureTimeMillis { InsertionSort(ArrayList(testList)) }.toInt()
    sortingTimes[insertionTime] = "INSERTION SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val insertionSortedList = ArrayList(testList)
    InsertionSort(insertionSortedList)
    insertionSortedList.checkSorted()
    print(insertionSortedList.getString()).also { println() }
    println("-----------")

    println("Merge sort")
    val mergeTime = measureTimeMillis { MergeSort(ArrayList(testList)) }.toInt()
    sortingTimes[mergeTime] = "MERGE SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val mergeSortedList = ArrayList(testList)
    MergeSort(mergeSortedList)
    mergeSortedList.checkSorted()
    print(mergeSortedList.getString()).also { println() }
    println("-----------")

    println("Quick sort")
    val quickTime = measureTimeMillis { QuickSort(ArrayList(testList)) }.toInt()
    sortingTimes[quickTime] = "QUICK SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val quickSortedList = ArrayList(testList)
    QuickSort(quickSortedList)
    quickSortedList.checkSorted()
    print(quickSortedList.getString()).also { println() }
    println("-----------")

    println("Sorting times, from fastest to slowest..")
    sortingTimes.forEach { time, name -> println("Time to sort a list of ${testList.size} elements using $name = $time ms") }

    readLine()
}
