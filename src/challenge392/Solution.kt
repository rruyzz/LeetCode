package challenge392

/**
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
 * of "abcde" while "aec" is not).
 */
class Solution {

    fun isSubsequence(s: String, t: String): Boolean {
        var subsequencePosition: Int = 0
        var stackSize = 0
        for (char in t) {
            if (subsequencePosition == s.length) return true
            if (char == s[subsequencePosition]) {
                subsequencePosition += 1
                stackSize += 1
            }
        }
        return subsequencePosition == s.length
    }
}

fun main() {
    println(Solution().isSubsequence("b", "abc"))
}
