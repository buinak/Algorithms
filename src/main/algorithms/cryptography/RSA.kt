package main.algorithms.cryptography

import main.algorithms.mathematics.areCoprime
import main.algorithms.mathematics.isPrime
import main.algorithms.mathematics.raiseToPower
import main.algorithms.mathematics.raiseToPowerBig
import java.math.BigInteger
import kotlin.random.Random

private fun generateRandomPrimePair(range: IntRange): Pair<Int, Int> {
    var num = Random.nextInt(range.first, range.endInclusive)
    while (!isPrime(num.toLong())) num = Random.nextInt(range.first, range.endInclusive)
    var num2 = Random.nextInt(range.first, range.endInclusive)
    while (!isPrime(num2.toLong())) num2 = Random.nextInt(range.first, range.endInclusive)
    return Pair(num, num2)
}

private fun generateRandomCoprime(range: IntRange, number: Int): Int {
    while (true) Random.nextInt(range.start, range.endInclusive).run {
        if (areCoprime(number.toLong(), this.toLong())) return this
    }
}

private fun generateRandomKeys(primeRange: IntRange): Pair<RSAPublicKey, RSAPrivateKey> {
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

private fun rsaEncrypt(message: Int, publicKey: RSAPublicKey): Long {
    return (raiseToPowerBig(message.toLong(), publicKey.exponent).mod(BigInteger.valueOf(publicKey.modulus.toLong())).toLong())
}

private fun rsaDecrypt(message: Int, privateKey: RSAPrivateKey): Long {
    val power = raiseToPowerBig(message.toLong(), privateKey.d)
    return (power % BigInteger.valueOf(privateKey.modulus.toLong())).toLong()
}

class RSAPublicKey(val modulus: Int, val exponent: Int)
class RSAPrivateKey(val modulus: Int, val d: Int)

fun main() {
    val pair = generateRandomKeys(2..200)
    println("Public key: Modulus = ${pair.first.modulus}, Exponent = ${pair.first.exponent}")
    println("Private key: Modulus = ${pair.second.modulus}, D = ${pair.second.d}")
    val encrypt = 5
    println("Encrypting $encrypt using the keys = ${rsaEncrypt(encrypt, pair.first)}")
    val result = rsaEncrypt(encrypt, pair.first)
    println("Decrypting $result using the keys = ${rsaDecrypt(result.toInt(), pair.second)}")
}