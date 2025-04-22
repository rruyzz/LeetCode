package challenge2609


class Solution {

    fun findTheLongestBalancedSubstring(s: String): Int {
        val intArray = s.toCharArray().map { it.digitToInt() }
        val balanced = mutableListOf<Int>()
        var equals = mutableListOf<Int>()
        intArray.forEachIndexed { index, value ->
            if (value == 0) {
                if(index != 0 && intArray[index - 1] == 1) balanced.clear()
                balanced.add(value)
            }
            if (value == 1) {
                if (balanced.isBalancedList()) {
                    balanced.add(value)
                    if (equals.size <= balanced.getEquals().size) {
                        equals = balanced.getEquals()
                    }
                }
            }
        }
        return equals.size
    }

    private fun MutableList<Int>.getEquals(): MutableList<Int> {
        val equals = mutableListOf<Int>()
        if (this.isEmpty()) return this
        for (index in 0..(this.lastIndex) / 2) {
            if (this[index] == 0 && this[this.lastIndex - index] == 1) {
                equals.add(index, this[index])
                equals.add(this[this.lastIndex - index])
            } else {
                break
            }
        }
        return equals
    }

    private fun List<Int>.isBalancedList(): Boolean {
        var hasFoundZero = false
        var hasFoundOne = false
        this.forEach {
            if (it == 0) {
                hasFoundZero = true
                if (hasFoundOne) return false
            }
            if (it == 1) {
                hasFoundOne = true
                if (hasFoundZero.not()) return false
            }
        }
        return hasFoundZero
    }
}

fun main() {
    println(Solution().findTheLongestBalancedSubstring("101")) // 2
    println(Solution().findTheLongestBalancedSubstring("00111")) // 4
    println(Solution().findTheLongestBalancedSubstring("00111")) // 4
    println(Solution().findTheLongestBalancedSubstring("01011")) // 2
    println(Solution().findTheLongestBalancedSubstring("001011")) // 2
    println(Solution().findTheLongestBalancedSubstring("00111")) // 4
    println(Solution().findTheLongestBalancedSubstring("01000111")) // 6
}