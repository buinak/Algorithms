package main.algorithms.mathematics

import java.math.BigInteger

fun raiseToPower(num: Long, pow: Int): Long {
    return if (pow == 1) num
    else raiseToPower(num, pow - 1) * num
}

fun raiseToPowerBig(num: Long, pow: Int): BigInteger {
    var result = BigInteger.valueOf(num)
    for (i in pow downTo 2) result *= BigInteger.valueOf(num)
    return result
}