package test.algorithms.problems

import main.algorithms.problems.solveQueensProblem
import org.junit.Test

import org.junit.Assert.*

class EightQueensProblemTest {

    @Test
    fun eightQueensProblem() {
        val map = HashMap<Int, Int>()
        map[1] = 1
        map[2] = 0
        map[3] = 0
        map[4] = 2
        map[5] = 10
        map[6] = 4
        map[7] = 40
        map[8] = 92
        map[9] = 352
        map[10] = 724
        for (entry in map.entries){
            var i = 0
            solveQueensProblem(entry.key) { i++ }
            assertEquals(entry.value, i)
        }
    }
}