package com.karnamic.dsainkotlin.arrays.practice

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toSet()
    var longest = 0

    for(num in nums) {
        if ((num-1) !in numSet) {
            var length = 1
            while(num+length in numSet) {
                length +=1
            }
            longest = maxOf(longest, length)
        }
    }

    return longest
}