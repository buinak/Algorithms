package main.algorithms.cryptography

fun vigenereEncrypt(text: String, key: String): String{
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')

    var newKey = ""
    var resultString = ""
    if (key.length > text.length) newKey = key.substring(0, text.length)
    if (key.isEmpty()) return text
    else {
        var current = 0
        while (newKey.length != text.length) {
            newKey += (if (key.length == 1) key[0] else key[current % (key.length)])
            current++
        }
    }
    newKey = newKey.toLowerCase()

    text.forEachIndexed { index, character ->
        if (alphabet.contains(character.toLowerCase())) {
            var newIndex = (alphabet.indexOf(character.toLowerCase()) + alphabet.indexOf(newKey[index])) % alphabet.size
            var newCharacter = if (character.isUpperCase()) alphabet[newIndex].toUpperCase() else alphabet[newIndex]
            resultString += newCharacter
        } else {
            resultString += character
        }
    }

    return resultString
}

fun vigenereDecrypt(text: String, key: String): String {
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')

    var newKey = ""
    var resultString = ""
    if (key.length > text.length) newKey = key.substring(0, text.length)
    if (key.isEmpty()) return text
    else {
        var current = 0
        while (newKey.length != text.length) {
            newKey += (if (key.length == 1) key[0] else key[current % (key.length)])
            current++
        }
    }
    newKey = newKey.toLowerCase()

    text.forEachIndexed { index, character ->
        if (alphabet.contains(character.toLowerCase())) {
            var newIndex = (alphabet.indexOf(character.toLowerCase()) - alphabet.indexOf(newKey[index]))
            if (newIndex < 0) newIndex += alphabet.size
            var newCharacter = if (character.isUpperCase()) alphabet[newIndex].toUpperCase() else alphabet[newIndex]
            resultString += newCharacter
        } else {
            resultString += character
        }
    }

    return resultString
}