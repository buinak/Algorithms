package searching

object BinarySearch {
    fun search(list: List<Int>, value: Int, startIndex: Int = 0, endIndex: Int = list.size - 1): Int{
        if (endIndex >= startIndex) {
            val mid = (startIndex + endIndex) / 2
            return when {
                list[mid] == value -> mid
                list[mid] < value -> search(list, value, mid + 1, endIndex)
                list[mid] > value -> search(list, value, startIndex, mid - 1)
                else -> -1
            }

        }
        return -1
    }
}