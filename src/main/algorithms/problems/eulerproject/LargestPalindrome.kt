package main.algorithms.problems.eulerproject

fun isPalindrome(n: Int): Boolean {
    var numberString = n.toString()
    numberString.forEachIndexed { index, char ->
        if (index > numberString.length) return true
        if (numberString[numberString.length - index - 1] != char) return false
    }
    return true
}

fun largestPalindromeSolution(): Int {
    var largestPalindrome = 0
    for (i in 100..999){
        for (j in 100..999){
            val num = i * j
            if (isPalindrome(num) && num > largestPalindrome) largestPalindrome = num
        }
    }
    return largestPalindrome
}

fun main() {
    println(largestPalindromeSolution())
}
