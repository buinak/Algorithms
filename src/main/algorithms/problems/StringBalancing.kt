package main.algorithms.problems

import java.util.*
import kotlin.collections.HashMap

fun isStringBalanced(s: String): Boolean {
    val bracketStack = Stack<Char>()
    val balancingCharacters = HashMap<Char, Char>()
    balancingCharacters['('] = ')'
    balancingCharacters['['] = ']'
    for (character in s){
        if (balancingCharacters.containsKey(character)) bracketStack.push(character)
        if (balancingCharacters.containsValue(character)) {
            if (bracketStack.empty()) return false
            if (balancingCharacters[bracketStack.pop()] != character) return false
        }
    }
    return bracketStack.empty()
}

fun main(args: Array<String>) {
    fun checkStr(s: String) = println("Checked balance for $s = ${isStringBalanced(s)}")

    checkStr("()")
    checkStr("(()")
    checkStr(")(")
    checkStr("([])")
    checkStr("([)]")
}