package main.algorithms.mathematics


fun areCoprime(first: Long, second: Long): Boolean {
    fun greatestCommonDivisor(first: Long, second: Long): Long {
        var smaller = if (first <= second) first else second
        var bigger = if (first > second) first else second

        return if (bigger % smaller == 0L) smaller
        else greatestCommonDivisor(smaller, bigger % smaller)
    }

    return greatestCommonDivisor(first, second) == 1L
}

fun returnAllCoprimes(number: Long, limit: Long = number): List<Long> {
    val result = ArrayList<Long>()
    for (i in 1..limit) if (areCoprime(number, i)) result.add(i)
    return result
}

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