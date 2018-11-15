fun <T> MutableList<T>.swap(indexFirst: Int, indexSecond: Int){
    val tmp = this[indexFirst]
    this[indexFirst] = this[indexSecond]
    this[indexSecond] = tmp
}

object SortingAlgorithms {

    fun selectionSort(list: MutableList<Int>){
        for (i in 0 until list.size) {
            var minIndex = i
            for (j in i + 1 until list.size){
                if (list[j] < list[minIndex]) minIndex = j
            }
            if (minIndex != i) {
                val tmp = list[i]
                list[i] = list[minIndex]
                list[minIndex] = tmp
            }
        }
    }

    fun insertionSort(list: MutableList<Int>){
        for (j in 1 until list.size){
            val key = list[j]
            var i = j - 1
            while (i >= 0 && list[i] > key){
                list[i + 1] = list[i]
                i -= 1
            }
            list[i + 1] = key
        }
    }

    fun bubbleSort(list: MutableList<Int>){
        var swapped: Boolean
        do {
            swapped = false
            for (i in 0 until list.size - 1){
                if (list[i] > list[i + 1]){
                    list.swap(i, i + 1)
                    swapped = true
                }
            }
        } while (swapped)
    }

    fun mergeSort(list: MutableList<Int>, p: Int = 0, r: Int = list.size - 1) {
        fun merge(list: MutableList<Int>, leftStart: Int, rightStart: Int, end: Int){
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

        if (p < r){
            val q = (p + r) / 2
            mergeSort(list, p, q)
            mergeSort(list, q + 1, r)
            merge(list, p, q, r)
        }
    }
}
