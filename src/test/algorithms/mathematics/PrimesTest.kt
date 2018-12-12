package test.algorithms.mathematics

import main.algorithms.mathematics.getAllPrimesPlain
import main.algorithms.mathematics.getAllPrimesSieve
import main.algorithms.mathematics.isPrime
import org.junit.Test

import org.junit.Assert.*

class PrimesTest {

    @Test
    fun isPrime() {
        val primes = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29,  31, 37, 41, 43, 47, 53, 59, 61, 67, 71,  73, 79, 83, 89, 97)
        val result = ArrayList<Int>()
        for (i in 1..97) {
            if (isPrime(i.toLong())) result.add(i)
        }
        assertEquals(result, primes)
    }

    @Test
    fun getAllPrimesSieveTest() {
        assertEquals(getAllPrimesSieve(100), getAllPrimesPlain(100))
    }

    @Test
    fun getAllPrimesPlainTest() {
        val primes = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29,  31, 37, 41, 43, 47, 53, 59, 61, 67, 71,  73, 79, 83, 89, 97)
        assertEquals(primes, getAllPrimesPlain(97))
    }
}