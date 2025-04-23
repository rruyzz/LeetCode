package challenge448

class Solution {
    //validar
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val range = mutableListOf<Int>()
        val disapperedNumbersSet = nums.toSet()
        val disapperedNumbers = mutableListOf<Int>()
        for (i in 1..nums.size){
            range.add(i)
        }
        println(range)
        range.forEach {
            if (disapperedNumbersSet.contains(it).not()) disapperedNumbers.add(it)
        }
        return disapperedNumbers.toList()
    }
}

fun main() {
    println(Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}