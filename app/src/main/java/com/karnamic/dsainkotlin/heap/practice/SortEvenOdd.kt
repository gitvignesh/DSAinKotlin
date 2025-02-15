package com.karnamic.dsainkotlin.heap.practice

import java.util.PriorityQueue

/**
 * You are given a 0-indexed integer array nums. Rearrange the values of nums according to the following rules:
 *
 * Sort the values at odd indices of nums in non-increasing order.
 * For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after. The values at odd indices 1 and 3 are sorted in non-increasing order.
 * Sort the values at even indices of nums in non-decreasing order.
 * For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after. The values at even indices 0 and 2 are sorted in non-decreasing order.
 * Return the array formed after rearranging the values of nums.
 */
fun sortEvenOdd(nums: IntArray): IntArray {
    val evenHeap = PriorityQueue<Int>()
    val oddHeap = PriorityQueue<Int> (compareByDescending { it })

    for (i in nums.indices) {
        if (i % 2 == 0) {
            evenHeap.add(nums[i])
        } else {
            oddHeap.add(nums[i])
        }
    }

    val result = IntArray(nums.size)

    for(i in nums.indices){
        if(i % 2 == 0){
            result[i] = evenHeap.poll()
        } else {
            result[i] = oddHeap.poll()
        }
    }

    return result
}