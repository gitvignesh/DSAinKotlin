package com.karnamic.dsainkotlin.arrays.practice

/***
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 *
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val output = HashMap<List<Int>, MutableList<String>>()

    for (word in strs) {
        val count = MutableList(26) { 0 }

        for (chr in word) {
            count[chr - 'a']++
        }

        output.getOrPut(count) { mutableListOf() }.add(word)
    }

    return output.values.toList()
}