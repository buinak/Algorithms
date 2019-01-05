package main.algorithms.problems

/**
 * Represents a chessboard matrix.
 * Can either be instantiated from an existing chessboard (in which case it copies it) or from a size,
 * in which case it fills all the cells with empty values.
 */
class Chessboard {

    val board = ArrayList<ArrayList<Int>>()

    /**
     * Fills the matrix with values representing empty cells.
     */
    constructor(size: Int) {
        for (i in 1..size) {
            val newList = ArrayList<Int>()
            for (j in 1..size) {
                newList.add(0)
            }
            board.add(newList)
        }
    }

    /**
     * Copies an existing chessboard. 
     */
    constructor(chessboard: Chessboard) {
        for (i in 0 until chessboard.board.size) {
            val newList = ArrayList<Int>()
            for (j in 0 until chessboard.board.size) {
                newList.add(0)
            }
            board.add(newList)
        }

        for (i in 0 until chessboard.board.size) {
            for (j in 0 until chessboard.board.size) {
                board[i][j] = chessboard.board[i][j]
            }
        }
    }
}

fun solveEightQueensProblem(size: Int): List<Chessboard> = eightQueensProblem(Chessboard(size), 0, ArrayList())

private fun isBoardSafe(chessboard: Chessboard): Boolean {
    for (i in 0 until chessboard.board.size) {
        if (!chessboard.board[i].contains(1)) continue
        val column = chessboard.board[i].indexOf(1)
        for (j in i + 1 until chessboard.board.size) {
            if (!chessboard.board[j].contains(1)) continue
            val columnSecond = chessboard.board[j].indexOf(1)
            if (column == columnSecond) return false
            if (Math.abs(column - columnSecond) == Math.abs(i - j)) return false
        }
    }
    return true
}

private fun eightQueensProblem(
    chessboard: Chessboard,
    currentRow: Int,
    solutions: ArrayList<Chessboard>
): List<Chessboard> {
    for (i in 0 until chessboard.board.size){
        chessboard.board[currentRow][i] = 1
        if (isBoardSafe(chessboard)) {
            if (currentRow == chessboard.board.size - 1){
                solutions.add(Chessboard(chessboard))
            } else {
                eightQueensProblem(chessboard, currentRow + 1, solutions)
            }
        }
        chessboard.board[currentRow][i] = 0
    }
    return solutions
}

fun main(args: Array<String>) {
    solveEightQueensProblem(4).forEach {
        println()
        it.board.forEach { row ->
            println()
            row.forEach { number -> print("$number ") }
        }
    }
}