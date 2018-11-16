package sorting

import swap

class QuickSort (list: MutableList<Int>) {
    init {
        quicksort(list, 0, list.size - 1)
    }

    private fun quicksort(list: MutableList<Int>, low: Int, high: Int){
        fun partition(list: MutableList<Int>, low: Int, high: Int): Int{
            val pivot = list[high]
            var i = low - 1
            for (j in low until high){
                if (list[j] < pivot && i != j){
                    i++
                    list.swap(i, j)
                }
            }
            i++
            list.swap(i, high)
            return i
        }

        if (low < high){
            val mid = partition(list, low, high)
            quicksort(list, low, mid - 1)
            quicksort(list, mid + 1, high)
        }
    }
}