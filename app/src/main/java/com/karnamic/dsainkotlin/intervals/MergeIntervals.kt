package com.karnamic.dsainkotlin.intervals

/***
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf<IntArray>()

    intervals.sortBy { it[0] }
    var result = arrayListOf<IntArray>()

    for ( interval in intervals) {
        if (result.isEmpty() || result.last()[1] < interval[0]) {
            result.add(interval)
        } else {
            result.last()[1] = maxOf(result.last()[1], interval[1])
        }
    }

    return result.toTypedArray()
}