package main.algorithms.mathematics

import kotlin.random.Random


/**
 * Two numbers are co-prime when the GCD of the numbers is 1.
 * This method uses an algorithm called the Euclidean algorithm to compute GCD.
 */
fun areCoprime(first: Long, second: Long): Boolean {
    fun greatestCommonDivisor(first: Long, second: Long): Long {
        var smaller = if (first <= second) first else second
        var bigger = if (first > second) first else second

        return if (bigger % smaller == 0L) smaller
        else greatestCommonDivisor(smaller, bigger % smaller)
    }

    return greatestCommonDivisor(first, second) == 1L
}

/**
 * Returns all co-primes starting from 1 of a number, where limit is the biggest number to be checked for coprimality.
 */
fun returnAllCoprimes(number: Long, limit: Long = number): List<Long> {
    val result = ArrayList<Long>()
    for (i in 1..limit) if (areCoprime(number, i)) result.add(i)
    return result
}

/**
 * Returns a specified amount of the closest co-primes in either direction from the number.
 */
fun returnClosestCoprimes(number: Long, amount: Int, increment: Boolean = false): List<Long> {
    val result = ArrayList<Long>()
    when (increment) {
        true -> {
            var i = number
            while (true) {
                if (areCoprime(number, ++i)) {
                    result.add(i)
                    if (result.size == amount) break
                }
            }
        }
        false -> {
            for (i in (number - 1) downTo 1) if (areCoprime(number, i)) {
                result.add(i)
                if (result.size == amount) break
            }
        }
    }

    return result
}

/**
 * Generates a random prime number within range, using isPrime() function to check for primality.
 */
fun generateRandomPrime(range: IntRange): Int{
    val count = range.count()
    var i = 0
    var number: Int
    do {
        number = Random.nextInt(range.start, range.endInclusive)
        if (isPrime(number.toLong())) return number
        i++
        if (i >= count) return -1
    } while (true)
}

/**
 * This method returns true if the number is a prime number.
 * Simply, it checks all the numbers up to the numbers square root and returns false if the number is divisible by any,
 * otherwise returns true.
 */
fun isPrime(num: Long): Boolean {
    if (num < 1) return false
    if (num > 10 && (num % 2 == 0L || num % 3 == 0L)) return false
    when (num) {
        in setOf<Long>(2, 3, 5, 7) -> return true
        in setOf<Long>(1, 4, 6, 8, 9) -> return false
        else -> {
            val sqrt = Math.sqrt(num.toDouble())
            for (i in 2..sqrt.toInt()) if (num % i == 0L) return false
        }
    }
    return true
}

fun getAllPrimesSieve(limit: Int): List<Int> {
    val result = ArrayList<Int>()
    for (i in 2..limit) {
        result.add(i)
    }
    var finished = false
    var currentIndex = 0
    while (!finished) {
        val currentNumber = result[currentIndex]
        val iterator = result.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next % currentNumber == 0 && next != currentNumber) iterator.remove()
        }
        if (currentIndex + 1 == result.size) finished = true
        else currentIndex++
    }
    return result
}

fun getAllPrimesPlain(limit: Int): List<Int> {
    val result = ArrayList<Int>()
    for (i in 2..limit) if (isPrime(i.toLong())) result.add(i)
    return result
}