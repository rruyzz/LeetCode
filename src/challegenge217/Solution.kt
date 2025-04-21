package challegenge217


class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map: MutableMap<Int, Int> = mutableMapOf()
        nums.forEach {
            println("antes $map")
            map[it] = map.getOrDefault(it, 0) + 1
            println("depois $map")
            if (map[it] == 2) return true
        }
        println(map)
        return false
    }
}

fun main() {
    println(Solution().containsDuplicate(intArrayOf(1,2,3,4)))
}