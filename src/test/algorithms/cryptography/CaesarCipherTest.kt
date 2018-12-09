package test.algorithms.cryptography

import main.algorithms.cryptography.caesarDecrypt
import main.algorithms.cryptography.caesarEncrypt
import org.junit.Test

import org.junit.Assert.*

class CaesarCipherTest {

    @Test
    fun caesarCipher() {
        val list = ArrayList<Pair<String, String>>()
        list.add(Pair("If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.",
            "Jg if ibe bozuijoh dpogjefoujbm up tbz, if xspuf ju jo djqifs, uibu jt, cz tp dibohjoh uif psefs pg uif mfuufst pg uif bmqibcfu, uibu opu b xpse dpvme cf nbef pvu."))
        list.add(Pair("If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.",
            "Kh jg jcf cpavjkpi eqphkfgpvkcn vq uca, jg ytqvg kv kp ekrjgt, vjcv ku, da uq ejcpikpi vjg qtfgt qh vjg ngvvgtu qh vjg cnrjcdgv, vjcv pqv c yqtf eqwnf dg ocfg qwv."))

        for (pair in list){
            assertEquals(pair.second, caesarEncrypt(pair.first, list.indexOf(pair) + 1))
            assertEquals(pair.first, caesarDecrypt(pair.second, list.indexOf(pair) + 1))
        }
    }
}