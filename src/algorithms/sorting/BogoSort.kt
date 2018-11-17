package algorithms.sorting

/**
 * Very inefficient. O((n+1)!)
 *
 * @author Konstantin Buinak (https://github.com/buinak)
 */
fun bogoSort(list: MutableList<Int>) {
    fun isSorted(list: List<Int>): Boolean {
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