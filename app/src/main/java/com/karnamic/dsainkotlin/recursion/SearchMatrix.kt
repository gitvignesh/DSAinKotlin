package com.karnamic.dsainkotlin.recursion

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var top = 0
    var bottom = matrix.size - 1

    fun searchInRow(row: IntArray): Boolean {

        if (top > bottom) {
            return false
        }

        var left = 0
        var right = row.size - 1
        while (left <= right) {
            val mid = left + (right-left)/2
            if (target < row[mid]){
                right = mid - 1
            } else if (target > row[mid]){
                left = mid + 1
            } else {
                return true
            }
        }
        return false
    }


    while (top <= bottom) {
        val mid = top + ((bottom-top)/2).toInt()
        if (target < matrix[mid].first()) {
            bottom = mid - 1
        } else if (target > matrix[mid].last()) {
            top = mid + 1
        } else {
            return searchInRow(matrix[mid])
        }
    }

    return false
}