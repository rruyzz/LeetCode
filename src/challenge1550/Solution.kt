package challenge1550

/**
 * 1550. Three Consecutive Odds
 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 */
class Solution {

    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var counter = 0
        arr.forEach {
            if (it.isOdd()) {
                counter += 1
            } else {
                counter = 0
            }
            if (counter == 3) return true
        }
        return false
    }

    private fun Int.isOdd() : Boolean {
        return when {
            this == 1 -> true
            this == 0 -> false
            this % 2 == 1 -> true
            else -> false
        }
    }
}

fun main() {
    println(Solution().threeConsecutiveOdds(intArrayOf(1, 3, 2)))
}
