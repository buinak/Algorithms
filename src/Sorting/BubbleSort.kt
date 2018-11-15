package Sorting

import swap

class BubbleSort (list: MutableList<Int>) {
    init {
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

}