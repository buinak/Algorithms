package main.algorithms.mathematics

import java.math.BigInteger

/**
 * Recursively raised a number to a certain power.
 * This method returns the original number is power is 1, otherwise multiplies the number on the result of calling itself
 * with decremented power.
 * This means that the number will be multiplied on itself (the original) n amount of times, where n is the power.
 */
fun raiseToPower(num: Long, pow: Int): Long {
    return if (pow == 1) num
    else raiseToPower(num, pow - 1) * num
}

fun raiseToPowerBig(num: Long, pow: Int): BigInteger {
    var result = BigInteger.valueOf(num)
    for (i in pow downTo 2) result *= BigInteger.valueOf(num)
    return result
}