package challenge1523

/**
 * 1523. Count Odd Numbers in an Interval Range
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 */

class Solution {
    fun countOdds(low: Int, high: Int): Int {
        return when {
            isBothOdds(low, high) -> handleBothOdds(low, high)
            isNoneOdds(low, high) -> handleNoneOdds(low, high)
            else -> handleExpection(low, high)
        }
    }

    fun isBothOdds(low: Int, high: Int) : Boolean {
        return low.isOdd() && high.isOdd()
    }

    fun isNoneOdds(low: Int, high: Int) : Boolean {
        return low.isOdd().not() && high.isOdd().not()
    }

    fun handleBothOdds(low: Int, high: Int) : Int {
        return  (high - low)/2 + 1
    }

    fun handleNoneOdds(low: Int, high: Int) : Int {
        return  (high - low)/2
    }

    fun handleExpection(low: Int, high: Int): Int{
        val value = if(high - low == 1) 1
        else (high-low)/2 + 1
        return value
    }
    fun Int.isOdd(): Boolean = this % 2 != 0
}

fun main() {
    println(Solution().countOdds(13, 18))
}