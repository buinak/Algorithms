fun main(args: Array<String>) {
    println(plainFactorial(5))
    println(recursiveFactorial(5))
}

fun plainFactorial(num: Int): Int{
    var product = 1
    for (i in 2..num) product *= i
    return product
}

fun recursiveFactorial(num: Int): Int{
    return if (num == 1) 1
    else num * recursiveFactorial(num - 1)
}