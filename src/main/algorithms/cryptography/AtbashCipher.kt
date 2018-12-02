package main.algorithms.cryptography

object AtbashCipher {
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')

    val reversedAlphabet = alphabet.reversed()
}

fun atbashEncrypt(text: String): String{
    var resultString = ""
    text.forEach {character ->
        val isUpperCase = character.isUpperCase()
        if (!AtbashCipher.alphabet.contains(character.toLowerCase())) resultString += character
        else {
            var newChar = AtbashCipher.reversedAlphabet[AtbashCipher.alphabet.indexOf(character.toLowerCase())]
            if (isUpperCase) newChar = newChar.toUpperCase()
            resultString += newChar
        }
    }
    return resultString
}

fun atbashDecrypt(text: String): String{
    var resultString = ""
    text.forEach {character ->
        val isUpperCase = character.isUpperCase()
        if (!AtbashCipher.alphabet.contains(character.toLowerCase())) resultString += character
        else {
            var newChar = AtbashCipher.alphabet[AtbashCipher.reversedAlphabet.indexOf(character.toLowerCase())]
            if (isUpperCase) newChar = newChar.toUpperCase()
            resultString += newChar
        }
    }
    return resultString
}