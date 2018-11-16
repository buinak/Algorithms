package sorting

class InsertionSort (list: MutableList<Int>) {
    init {
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
}