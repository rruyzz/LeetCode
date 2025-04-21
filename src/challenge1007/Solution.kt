package challenge1007

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms
 * are the same.
 *
 * If it cannot be done, return -1.
 */

class Solution {


    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        // find the number that should be inline
        val baseNumber = findBaseNumber(tops, bottoms)
        if (hasBaseNumber(baseNumber, tops, bottoms)) return -1
        return rotate(baseNumber, tops, bottoms)
    }

    private fun rotate(baseNumber: Int, tops: IntArray, bottoms: IntArray): Int {
        var differentBottom = 0
        var differentTop = 0
        for (i in 0..tops.size - 1) {
            if (tops[i] != baseNumber && bottoms[i] != baseNumber) return -1
            if (tops[i] == baseNumber && bottoms[i] != baseNumber) differentBottom += 1
            if (bottoms[i] == baseNumber && tops[i] != baseNumber) differentTop += 1
        }
        return if (differentBottom < differentTop) differentBottom else if (differentTop < differentBottom) differentTop else differentBottom
    }

    private fun findBaseNumber(tops: IntArray, bottoms: IntArray): Int {
        val dominoTop = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
        val dominoBottom = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
        tops.forEach { topValue ->
            dominoTop[topValue] = dominoTop.getOrDefault(topValue, 0) + 1
        }
        bottoms.forEach { topValue ->
            dominoBottom[topValue] = dominoBottom.getOrDefault(topValue, 0) + 1
        }

        val topMaxIncrement: Int = dominoTop.values.maxOrNull() ?: 0
        val bottomMaxIncrement: Int = dominoBottom.values.maxOrNull() ?: 0

        val baseNumber = if (topMaxIncrement >= bottomMaxIncrement) getMaxValue(dominoTop, dominoBottom)
        else getMaxValue(dominoBottom, dominoTop)
        return baseNumber
    }

    private fun getMaxValue(mapWithMaxIncrement: MutableMap<Int, Int>, mapToCompare: MutableMap<Int, Int>): Int {
        val maxIncrement = mapWithMaxIncrement.values.maxOrNull()
        val filtered = mapWithMaxIncrement.filterValues { it == maxIncrement }
        if (filtered.size == 1) return filtered.entries.firstOrNull { it.value == maxIncrement }?.key ?: -1

        val maxValueCompare = mapToCompare.values.maxOrNull()
        val filteredCompare = mapToCompare.filterValues { it == maxIncrement }
        if (filtered.size == 1) return maxValueCompare ?: -1
        filteredCompare.forEach { key, value ->
            filtered.filterKeys { it == key }
        }

        return filteredCompare.minByOrNull { it.key }?.key ?: -1
    }

    private fun hasBaseNumber(baseNumber: Int, tops: IntArray, bottoms: IntArray): Boolean {
        for (i in 0..tops.size - 1) {
            if (tops[i] != baseNumber && bottoms[i] != baseNumber) return true
        }
        return false
    }
}

fun main() {
//    println(Solution().minDominoRotations(intArrayOf(1, 2, 1, 1, 1, 2, 2, 2), intArrayOf(2, 1, 2, 2, 2, 2, 2, 2)))
    println(Solution().minDominoRotations(intArrayOf(2, 1, 2, 4, 2, 2), intArrayOf(5, 2, 6, 2, 3, 2)))
//    println(Solution().minDominoRotations(intArrayOf(1, 1, 1, 1, 1, 1), intArrayOf(1, 1, 1, 1, 1, 1)))
//    println(Solution().minDominoRotations(intArrayOf(2, 2, 2, 4, 4, 4), intArrayOf(4, 4, 4, 2, 3, 2)))
//    println(Solution().minDominoRotations(intArrayOf(1, 2, 3, 4, 6), intArrayOf(6, 6, 6, 6, 5)))
//    println(Solution().minDominoRotations(intArrayOf(1,2,1,1,1,2,2,2), intArrayOf(2,1,2,2,2,2,2,2)))
}

//3,5,1,2,3
//3,6,3,3,4

//1,2,1,1,1,2,2,2
//2,1,2,2,2,2,2,2

//2,1,2,4,2,2
//5,2,6,2,3,2

class Solutions {

    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        // find the number that should be inline
        val baseNumber = findBaseNumber(tops, bottoms)
        if (hasBaseNumber(baseNumber, tops, bottoms)) return -1
        return rotate(baseNumber, tops, bottoms)
    }

    private fun rotate(baseNumber: Int, tops: IntArray, bottoms: IntArray): Int {
        var differentBottom = 0
        var differentTop = 0
        println(baseNumber)
        for (i in 0..tops.size - 1) {
            if (tops[i] != baseNumber && bottoms[i] != baseNumber) return -1
            if (tops[i] == baseNumber && bottoms[i] != baseNumber) differentBottom += 1
            if (bottoms[i] == baseNumber && tops[i] != baseNumber) differentTop += 1
        }
        return if (differentBottom < differentTop) differentBottom else if (differentTop < differentBottom) differentTop else differentBottom
    }

    private fun findBaseNumber(tops: IntArray, bottoms: IntArray): Int {
        val dominoTop = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
        val dominoBottom = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
        tops.forEach { topValue ->
            dominoTop[topValue] = dominoTop.getOrDefault(topValue, 0) + 1
        }
        bottoms.forEach { topValue ->
            dominoBottom[topValue] = dominoBottom.getOrDefault(topValue, 0) + 1
        }


        val topMaxIncrement: Int = dominoTop.values.maxOrNull() ?: 0
        val bottomMaxIncrement: Int = dominoBottom.values.maxOrNull() ?: 0

        val baseNumber = if (topMaxIncrement >= bottomMaxIncrement) dominoTop.maxBy { it.value }.key
        else dominoBottom.maxBy { it.value }.key

        return baseNumber
    }

    private fun hasBaseNumber(baseNumber: Int, tops: IntArray, bottoms: IntArray): Boolean {
        for (i in 0..tops.size - 1) {
            if (tops[i] != baseNumber && bottoms[i] != baseNumber) return true
        }
        return false
    }
}