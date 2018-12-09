package test.algorithms.cryptography

import main.algorithms.cryptography.atbashDecrypt
import main.algorithms.cryptography.atbashEncrypt
import org.junit.Test

import org.junit.Assert.*

class AtbashCipherTest {

    @Test
    fun atbashCipher() {
        val list = ArrayList<Pair<String, String>>()
        list.add(Pair("cat", "xzg"))
        list.add(Pair("A quick brown FOX jumped over the lazy dog.", "Z jfrxp yildm ULC qfnkvw levi gsv ozab wlt."))
        list.add(Pair("Atbash Cipher!", "Zgyzhs Xrksvi!"))

        for (pair in list){
            assertEquals(pair.second, atbashEncrypt(pair.first))
            assertEquals(pair.first, atbashDecrypt(pair.second))
        }
    }

}