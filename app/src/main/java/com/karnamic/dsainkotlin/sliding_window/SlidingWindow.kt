package com.karnamic.dsainkotlin.sliding_window

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 */

fun lengthOfLongestSubstring(s: String): Int {
    val currSet = mutableSetOf<Char>()
    var startIndex = 0
    var currMax = 0

    for (endIndex in s.indices) {
        while ( s[endIndex] in currSet ){
            currSet.remove(s[startIndex])
            startIndex += 1
        }
        currSet.add (s[endIndex])
        currMax = maxOf(currMax, endIndex-startIndex + 1)
    }


    return currMax
}