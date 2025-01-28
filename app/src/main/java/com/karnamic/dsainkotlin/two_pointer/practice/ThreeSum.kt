package com.karnamic.dsainkotlin.two_pointer.practice

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for(i in nums.indices) {
        val target = 0 - nums[i]

        if(i>0 && nums[i] == nums[i-1]) continue;

        val res = twoSumList(target, nums.slice(i+1 until nums.size))
        if (res.isNotEmpty()) {
            res.forEach { list ->
                result.add(
                    listOf(nums[i], list[0], list[1])
                )
            }
        }
    }

    return result
}

fun twoSumList(target: Int, nums: List<Int>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    var left = 0
    var right = nums.size-1

    while(left < right) {
        val sum = nums[left] + nums[right]
        if (sum < target) {
            left++
        } else if (sum > target) {
            right--
        } else {
            result.add(listOf(nums[left], nums[right]))
            left++
            right--
            while (left < right && nums[left-1] == nums[left]) left++
            while (left < right && nums[right+1] == nums[right]) right--
        }
    }

    return result
}