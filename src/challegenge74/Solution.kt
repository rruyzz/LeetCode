package challegenge74


class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        matrix.forEach { row ->
            if (target <= row.last()) {
                return row.contains(target)
            }
        }
        return false
    }
}

fun main() {
    println(
        Solution().searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60),
            ),
            3
        )
    )
}