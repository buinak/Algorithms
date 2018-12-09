package main.algorithms.problems

fun solveQueensProblem(size: Int) {
    recursivelyFindSolutionsAndPrint(Chessboard(size))
}
fun solveQueensProblem(size: Int, f: (Chessboard) -> Unit){
    recursivelyFindSolutionsAndPrint(Chessboard(size), 0, f)
}

private fun recursivelyFindSolutionsAndPrint(chessBoard: Chessboard, currentRow: Int = 0, f: (Chessboard) -> Unit) {
    for (i in 0 until chessBoard.dimension) {
        val newChessBoard = Chessboard(chessBoard.dimension)
        newChessBoard.copyBoard(chessBoard)
        newChessBoard.putQueen(currentRow, i)
        if (newChessBoard.isSafe()) {
            if (currentRow != (chessBoard.dimension - 1)) {
                recursivelyFindSolutionsAndPrint(newChessBoard, currentRow + 1, f)
            } else {
                f(newChessBoard)
            }
        }
    }
}

private fun recursivelyFindSolutionsAndPrint(chessBoard: Chessboard, currentRow: Int = 0) {
    for (i in 0 until chessBoard.dimension) {
        val newChessBoard = Chessboard(chessBoard.dimension)
        newChessBoard.copyBoard(chessBoard)
        newChessBoard.putQueen(currentRow, i)
        if (newChessBoard.isSafe()) {
            if (currentRow != (chessBoard.dimension - 1)) {
                recursivelyFindSolutionsAndPrint(newChessBoard, currentRow + 1)
            } else {
                newChessBoard.printBoard()
            }
        }
    }
}

class Chessboard(val dimension: Int) {
    private val board = ArrayList<ArrayList<Int>>()

    init {
        for (i in 1..dimension) {
            val newList = ArrayList<Int>()
            for (j in 1..dimension) {
                newList.add(0)
            }
            board.add(newList)
        }
    }

    fun copyBoard(chessboard: Chessboard) {
        for (i in 0 until chessboard.dimension){
            if (chessboard.board[i].contains(1)) {
                val column = chessboard.board[i].indexOf(1)
                board[i][column] = 1
            }
        }
    }

    fun putQueen(row: Int, column: Int) {
        if (row > dimension || column > dimension) return
        board[row][column] = 1
    }

    fun isSafe(): Boolean {
        for (i in 0 until board.size) {
            val row = board[i]
            if (row.contains(1)) {
                if (row.count { it == 1 } > 1) return false
                val columnNumber = row.indexOf(1)
                val rowNumber = board.indexOf(row)
                //collision check
                for (j in 0 until board.size) {
                    if (j == i) continue
                    if (!board[j].contains(1)) continue
                    val columnNumberQueen = board[j].indexOf(1)
                    //if the column matches
                    if (columnNumber == columnNumberQueen) return false
                    //check for diagonal collisions
                    if (Math.abs(j - i) == Math.abs(columnNumber - columnNumberQueen)) return false
                }
            }
        }
        return true
    }

    fun printBoard() {
        println()
        for (row in board){
            var rowString = "{ "
            for (element in row){
                rowString += "$element "
            }
            rowString += "}"
            println(rowString)
        }
        println()
    }
}