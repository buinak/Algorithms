fun <T> MutableList<T>.swap(indexFirst: Int, indexSecond: Int){
    val tmp = this[indexFirst]
    this[indexFirst] = this[indexSecond]
    this[indexSecond] = tmp
}