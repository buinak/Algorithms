package utils

import kotlin.random.Random

fun generateRandomList(size: Int, range: IntRange): MutableList<Int> {
    val resultList = ArrayList<Int>(size)
    for (i in 1..size){
        resultList.add(Random.nextInt(range.start, range.endInclusive))
    }
    return resultList
}