package algorithms.sorting

import utils.swap

    fun <T: Comparable<T>> quicksort(list: MutableList<T>, low: Int = 0, high: Int = list.size - 1){
        fun partition(list: MutableList<T>, low: Int, high: Int): Int{
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