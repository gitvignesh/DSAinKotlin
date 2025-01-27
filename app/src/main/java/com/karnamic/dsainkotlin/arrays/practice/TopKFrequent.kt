package com.karnamic.dsainkotlin.arrays.practice

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 */

// Bruteforce solution
fun topKFrequentBrute(nums: IntArray, k: Int): IntArray {
    val countMap = hashMapOf<Int, Int>()

    nums.forEach {
        countMap[it] = countMap.getOrDefault(it, 0) + 1
    }

    val sortedList = mutableListOf<Pair<Int, Int>>()

    for((num, freq) in countMap) {
        sortedList.add(Pair(freq, num))
    }

    sortedList.sortByDescending { it. first }

    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = sortedList[i].second
    }

    return result
}


//Optimised Solution
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val countMap = hashMapOf<Int, Int>()

    nums.forEach {
        countMap[it] = countMap.getOrDefault(it, 0) + 1
    }

    val frequencyBucketList = MutableList(nums.size + 1) {
        mutableListOf<Int>()
    }

    for ((num, frq) in countMap) {
        frequencyBucketList[frq].add(num)
    }


    val result = mutableListOf<Int>()
    for (i in frequencyBucketList.size-1 downTo 0) {
        for( num in frequencyBucketList[i] ){
            result.add(num)

            if (result.size == k) {
                return result.toIntArray()
            }
        }
    }

    return result.toIntArray()
}