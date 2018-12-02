package main.algorithms.cryptography

fun atbashEncrypt(text: String): String{
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')
    val reversedAlphabet = alphabet.reversed()

    var resultString = ""
    text.forEach {character ->
        if (!alphabet.contains(character.toLowerCase())) resultString += character
        else {
            var newChar = reversedAlphabet[alphabet.indexOf(character.toLowerCase())]
            if (character.isUpperCase()) newChar = newChar.toUpperCase()
            resultString += newChar
        }
    }
    return resultString
}

fun atbashDecrypt(text: String): String{
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')
    val reversedAlphabet = alphabet.reversed()

    var resultString = ""
    text.forEach {character ->
        if (!alphabet.contains(character.toLowerCase())) resultString += character
        else {
            var newChar = alphabet[reversedAlphabet.indexOf(character.toLowerCase())]
            if (character.isUpperCase()) newChar = newChar.toUpperCase()
            resultString += newChar
        }
    }
    return resultString
}