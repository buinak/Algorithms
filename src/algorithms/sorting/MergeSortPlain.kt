package algorithms.sorting

fun <T : Comparable<T>> mergeSortPlain(list: MutableList<T>, start: Int = 0, end: Int = list.size - 1) {
    if (end > start) {
        val mid = (end + start) / 2
        mergeSortPlain(list, start, mid)
        mergeSortPlain(list, mid + 1, end)
        merge(list, start, mid, end)

    }
}

private fun <T : Comparable<T>> merge(list: MutableList<T>, start: Int, mid: Int, end: Int) {
    val numLeft = mid - start + 1
    val numRight = end - mid
    var leftList = ArrayList<T>(numLeft + 1)
    val rightList = ArrayList<T>(numRight + 1)
    for (i in 1..numLeft) {
        leftList.add(list[start + i - 1])
    }
    for (i in 1..numRight) {
        rightList.add(list[mid + i])
    }
    var i = 0
    var j = 0
    for (k in start..end) {
        list[k] = if (leftList[i] < rightList[j]) leftList[i++] else rightList[j++]
        if (i == numLeft) {
            for (p in (k + 1)..end) {
                list[p] = rightList[j++]
            }
            return
        }
        if (j == numRight) {
            for (p in (k + 1)..end) {
                list[p] = leftList[i++]
            }
            return
        }
    }

}