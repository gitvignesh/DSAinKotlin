package com.karnamic.dsainkotlin.arrays.practice

/**
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */

fun productExceptSelf(nums: IntArray): IntArray {
    val size = nums.size
    val result = IntArray(size) { 1 }

    var prefix = 1
    for (i in nums.indices) {
        result[i] = prefix
        prefix *= nums[i]
    }

    var postfix = 1
    for (i in size-1 downTo 0) {
        result[i] *= postfix
        postfix *= nums[i]
    }

    return result
}

/** Division
 *
 * fun productExceptSelf(nums: IntArray): IntArray {
 *         val size = nums.size
 *         val result = IntArray(size) { 0 }
 *         var fullProduct = 1
 *         var zeroCount = 0
 *
 *         nums.forEach {
 *             if (it != 0) {
 *                 fullProduct *= it
 *             } else {
 *                 zeroCount += 1
 *             }
 *         }
 *
 *         if (zeroCount > 1) {return result}
 *
 *         for( i in 0 until size) {
 *             if(zeroCount == 0) {
 *                 result[i] = fullProduct/nums[i]
 *             } else {
 *                 if (nums[i] == 0) {
 *                     result[i] = fullProduct
 *                 } else {
 *                     result[i] = 0
 *                 }
 *             }
 *         }
 *
 *         return result
 *     }
 */

/** Bruteforce
 *
 * fun productExceptSelf(nums: IntArray): IntArray {
 *     val size = nums.size
 *     val result = IntArray(size)
 *
 *     for( i in 0 until size) {
 *         var prod = 1
 *         for (j in 0 until size) {
 *             if(j == i) {
 *                 continue;
 *             }
 *             prod *= nums[j]
 *         }
 *         result[i] = prod
 *     }
 *
 *     return result
 * }
 */


