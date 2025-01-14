package com.karnamic.dsainkotlin.arrays.practice

/**
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 *
 * Example 1:
 * Input: ["neet","code","love","you"]
 * Output:["neet","code","love","you"]
 */

fun encodeString(wordList: List<String>): String {
    var encodedString = ""
    wordList.forEach {
        encodedString += it.length.toString() + "#${it}"
    }
    return encodedString
}

fun decodeString(encodedString: String): List<String> {
    val originalList = mutableListOf<String>()
    var i = 0
    while (i in encodedString.indices) {
        var j = 0
        while (encodedString[j] != '#') {
            j++
        }
        val wordLength = encodedString.substring(i, i+j).toInt()
        val startIndex = i+j+1
        originalList.add(encodedString.substring(startIndex, startIndex + wordLength))
        i += j+1+wordLength
    }
    return originalList
}