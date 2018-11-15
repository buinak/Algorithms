package Sorting

class SelectionSort (list: MutableList<Int>) {
    init {
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
}