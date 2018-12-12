package main.algorithms.cryptography

import main.algorithms.mathematics.areCoprime
import main.algorithms.mathematics.isPrime
import main.algorithms.mathematics.raiseToPower
import java.security.PrivateKey
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

private fun generateRandomKeys(): Pair<RSAPublicKey, RSAPrivateKey> {
//    val randomPrimes = generateRandomPrimePair(50..100)
    val randomPrimes = Pair(173, 149)
    val n = randomPrimes.first * randomPrimes.second
    val totient = (randomPrimes.first - 1) * (randomPrimes.second - 1)
//    val e = generateRandomCoprime(2 until 20, totient)
    val e = 3
    val d = (1 % totient) / e
    val private = RSAPrivateKey(n, d)
    val public = RSAPublicKey(n, e)
    return Pair(public, private)
}

private fun rsaEncrypt(message: Int, publicKey: RSAPublicKey): Long {
    return (raiseToPower(message.toLong(), publicKey.exponent) % publicKey.modulus)
}

private fun rsaDecrypt(message: Int, privateKey: RSAPrivateKey): Long {
    val power = raiseToPower(message.toLong(), privateKey.d)
    val result = power % privateKey.modulus
    return result
}

class RSAPublicKey(val modulus: Int, val exponent: Int)
class RSAPrivateKey(val modulus: Int, val d: Int)

fun main() {
    val pair = generateRandomKeys()
    println("Public key: Modulus = ${pair.first.modulus}, Exponent = ${pair.first.exponent}")
    println("Private key: Modulus = ${pair.second.modulus}, D = ${pair.second.d}")
    println("Encrypting 15 using the keys = ${rsaEncrypt(15, pair.first)}")
    val result = rsaEncrypt(15, pair.first)
    println("Decrypting $result using the keys = ${rsaDecrypt(result.toInt(), pair.second)}")
}