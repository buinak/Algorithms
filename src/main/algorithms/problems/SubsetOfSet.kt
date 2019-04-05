package main.algorithms.problems

fun <T> powerset(list: List<T>): List<List<T>> {
    val powerSet = ArrayList<List<T>>()
    val max = (Math.pow(2.0, list.size.toDouble()) - 1).toInt()
    val length = Integer.toBinaryString(max).length
    for (i in 0..max){
        var binaryString = Integer.toBinaryString(i).padStart(length, '0')
        val set = ArrayList<T>()
        binaryString.forEachIndexed { index, char ->
            if (char == '1'){
                set.add(list[index])
            }
        }
        powerSet.add(set)
    }
    return powerSet
}