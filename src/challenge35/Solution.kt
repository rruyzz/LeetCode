package challenge35

/**
 * 35. Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
class Solution {

    fun searchInsert(nums: IntArray, target: Int): Int {
        for ((index, value) in nums.withIndex()) {
            if (value > target || value == target) return index
        }
        return nums.size
    }
}

fun main() {
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5))
}
