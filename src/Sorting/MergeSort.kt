package sorting

class MergeSort (list: MutableList<Int>) {
    init {
        mergeSort(list)
    }

    private fun merge(list: MutableList<Int>, leftStart: Int, rightStart: Int, end: Int){
        val numberOfEntriesLeft = rightStart - leftStart + 1
        val numberOfEntriesRight = end - rightStart
        val leftList = ArrayList<Int>()
        val rightList = ArrayList<Int>()
        for (i in 1..numberOfEntriesLeft){
            leftList.add(list[leftStart + i - 1])
        }
        for (i in 1..numberOfEntriesRight){
            rightList.add(list[rightStart + i])
        }
        leftList.add(Int.MAX_VALUE)
        rightList.add(Int.MAX_VALUE)
        var i = 0
        var j = 0
        for (k in leftStart..end){
            if (leftList[i] < rightList[j]){
                list[k] = leftList[i++]
            } else {
                list[k] = rightList[j++]
            }
        }
    }

    private fun mergeSort(list: MutableList<Int>, p: Int = 0, r: Int = list.size - 1) {
        if (p < r){
            val q = (p + r) / 2
            mergeSort(list, p, q)
            mergeSort(list, q + 1, r)
            merge(list, p, q, r)
        }
    }
}