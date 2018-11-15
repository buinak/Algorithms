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

fun getRandom(lowerBound: Int, upperBound: Int) = Random().nextInt(upperBound - lowerBound) + lowerBound

fun getRandom(upperBound: Int) = Random().nextInt(upperBound)



fun main(args: Array<String>) {
    var testList = ArrayList<Int>()
    for (i in 1..50000) {
        testList.add(getRandom(1, 300))
    }
//    val testList = listOf(7, 1, 3, 2, 10, 12, 8)
    val sortingTimes = TreeMap<Int, String>()

    println("Bubble sort")
    val bubbleTime = measureTimeMillis { SortingAlgorithms.bubbleSort(ArrayList(testList)) }.toInt()
    sortingTimes[bubbleTime] = "BUBBLE SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val bubbleSortedList = ArrayList(testList)
    SortingAlgorithms.bubbleSort(bubbleSortedList)
    bubbleSortedList.checkSorted()
    print(bubbleSortedList.getString()).also { println() }
    println("-----------")

    println("Selection sort")
    val selectionTime = measureTimeMillis { SortingAlgorithms.selectionSort(ArrayList(testList)) }.toInt()
    sortingTimes[selectionTime] = "SELECTION SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val selectionSortedList = ArrayList(testList)
    SortingAlgorithms.selectionSort(selectionSortedList)
    selectionSortedList.checkSorted()
    print(selectionSortedList.getString()).also { println() }
    println("-----------")

    println("Insertion sort")
    val insertionTime = measureTimeMillis { SortingAlgorithms.insertionSort(ArrayList(testList)) }.toInt()
    sortingTimes[insertionTime] = "INSERTION SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val insertionSortedList = ArrayList(testList)
    SortingAlgorithms.insertionSort(insertionSortedList)
    insertionSortedList.checkSorted()
    print(insertionSortedList.getString()).also { println() }
    println("-----------")

    println("Merge sort")
    val mergeTime = measureTimeMillis { SortingAlgorithms.mergeSort(ArrayList(testList)) }.toInt()
    sortingTimes[mergeTime] = "MERGE SORT"
    println("Before sorting: ")
    print(testList.getString()).also { println() }
    println("After sorting: ")
    val mergeSortedList = ArrayList(testList)
    SortingAlgorithms.mergeSort(mergeSortedList)
    mergeSortedList.checkSorted()
    print(mergeSortedList.getString()).also { println() }
    println("-----------")

    println("Sorting times, from fastest to slowest..")
    sortingTimes.forEach { time, name -> println("Time to sort a list of ${testList.size} elements using $name = $time ms") }

    readLine()
}
