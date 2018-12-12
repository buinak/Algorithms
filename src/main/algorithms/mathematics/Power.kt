package main.algorithms.mathematics

fun raiseToPower(num: Long, pow: Int): Long {
    return if (pow == 1) num
    else raiseToPower(num, pow - 1) * num
}