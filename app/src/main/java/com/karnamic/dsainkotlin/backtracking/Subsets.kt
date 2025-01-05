package com.karnamic.dsainkotlin.backtracking

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

/** Iterative Solution */
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>(listOf())

    for (num in nums) {
        val size = result.size
        for (i in 0 until size) {
            val subset = result[i].toMutableList()
            subset.add(num)
            result.add(subset)
        }
    }

    return result
}