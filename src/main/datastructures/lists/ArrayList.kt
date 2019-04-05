package main.datastructures.lists

class ArrayList<T>(size: Int = 10){
    private var array = Array<Any?>(size) { }
    private var currentLength = size
    private var lastIndex = -1

    fun add(element: T){
        if (lastIndex + 1 == currentLength){
            var newArray = Array<Any?>(currentLength * 2) {  }
            array.forEachIndexed { index, e -> newArray[index] = e }
            array = newArray
            currentLength *= 2
        }
        array[++lastIndex] = element!!
    }

    fun get(index: Int): T? {
        if (index > lastIndex) return null
        return array[index] as T
    }

    fun remove(index: Int){
        if (index > lastIndex) return
        array[index] = null
        for (i in index until array.size - 1){
            array[i] = array[i + 1]
        }
    }

    fun size() = lastIndex + 1
    fun maxCapacity() = currentLength
    fun isEmpty() = lastIndex == -1
}