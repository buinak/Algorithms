package test.algorithms.cryptography

import junit.framework.Assert.assertEquals
import main.algorithms.cryptography.generateRandomKeys
import main.algorithms.cryptography.rsaDecrypt
import main.algorithms.cryptography.rsaEncrypt
import org.junit.Test
import test.TestConstants
import kotlin.random.Random

class RSATest {

    @Test
    fun rsaShouldWork() {
        for (i in 1..TestConstants.AMOUNT_OF_TESTS) {
            val number = Random.nextInt(1, 1000)
            val keyPair = generateRandomKeys(1..100, number)
            val encrypted = rsaEncrypt(number, keyPair.first)
            val decrypted = rsaDecrypt(encrypted, keyPair.second)
            assertEquals(number, decrypted.toInt())
        }
    }
}