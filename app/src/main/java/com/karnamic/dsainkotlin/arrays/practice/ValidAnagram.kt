package com.karnamic.dsainkotlin.arrays.practice

/***
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 * Input: s = "racecar", t = "carrace"
 * Output: true
 *
 * Example 2:
 * Input: s = "jar", t = "jam"
 * Output: false
 *
 * Constraints:
 * s and t consist of lowercase English letters.
 */

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val countS = mutableMapOf<Char, Int>()
    val countT = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        countS[s[i]] = countS.getOrDefault(s[i], 0) + 1
        countT[t[i]] = countT.getOrDefault(t[i], 0) + 1
    }

    return countS == countT
}