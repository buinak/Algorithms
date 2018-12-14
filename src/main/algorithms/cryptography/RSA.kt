package main.algorithms.cryptography

import main.algorithms.mathematics.areCoprime
import main.algorithms.mathematics.generateRandomPrime
import main.algorithms.mathematics.raiseToPowerBig
import java.math.BigInteger
import kotlin.random.Random

private fun generateRandomPrimePair(range: IntRange): Pair<Int, Int> {
    var num1 = generateRandomPrime(range)
    var num2 = generateRandomPrime(range)
    while (num2 == num1) num2 = generateRandomPrime(range)
    return Pair(num1, num2)
}

private fun generateRandomCoprime(range: IntRange, number: Int): Int {
    while (true) Random.nextInt(range.start, range.endInclusive).run {
        if (areCoprime(number.toLong(), this.toLong())) return this
    }
}

fun generateRandomKeys(primeRange: IntRange): Pair<RSAPublicKey, RSAPrivateKey> {
    fun generateE(intRange: IntRange, n: Int, phi: Int): Int{
        for (i in intRange){
            if (areCoprime(i.toLong(), n.toLong()) && areCoprime(i.toLong(), phi.toLong())) return i
        }
        return 1
    }
    fun generateD(e: Int, phi: Int, intRange: IntRange): Int{
        for (number in intRange){
            if ((number * e) % phi == 1) return number
        }
        return -1
    }

    val randomPrimes = generateRandomPrimePair(primeRange)
    val n = randomPrimes.first * randomPrimes.second
    val phi = (randomPrimes.first - 1) * (randomPrimes.second - 1)
    val e = generateE(2 until phi, n, phi)
    val d = generateD(e, phi, 2 until phi)

    val private = RSAPrivateKey(n, d)
    val public = RSAPublicKey(n, e)
    return Pair(public, private)
}

fun rsaEncrypt(message: Int, publicKey: RSAPublicKey): Long {
    return (raiseToPowerBig(message.toLong(), publicKey.exponent).mod(BigInteger.valueOf(publicKey.modulus.toLong())).toLong())
}

fun rsaDecrypt(message: Long, privateKey: RSAPrivateKey): Long {
    val power = raiseToPowerBig(message, privateKey.d)
    return (power % BigInteger.valueOf(privateKey.modulus.toLong())).toLong()
}

class RSAPublicKey(val modulus: Int, val exponent: Int)
class RSAPrivateKey(val modulus: Int, val d: Int)