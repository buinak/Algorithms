package main.algorithms.cryptography

fun caesarEncrypt(text: String, shift: Int): String{
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')

    val moduledShift = shift % alphabet.size
    if (moduledShift == 0) return text

    var resultString = ""
    text.forEach { character ->
        if (!alphabet.contains(character.toLowerCase())) resultString += character
        else {
            var newIndex = (alphabet.indexOf(character.toLowerCase()) + moduledShift) % alphabet.size
            resultString += if (character.isUpperCase()) alphabet[newIndex].toUpperCase() else alphabet[newIndex]
        }
    }
    return resultString
}

fun caesarDecrypt(text: String, shift: Int): String{
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z')

    var moduledShift = shift % alphabet.size
    if (moduledShift == 0) return text

    var resultString = ""
    text.forEach { character ->
        if (!alphabet.contains(character.toLowerCase())) resultString += character
        else {
            var newIndex = alphabet.indexOf(character.toLowerCase()) - moduledShift
            if (newIndex < 0) newIndex += alphabet.size
            resultString += if (character.isUpperCase()) alphabet[newIndex].toUpperCase() else alphabet[newIndex]
        }
    }
    return resultString
}