package com.karnamic.dsainkotlin

import com.karnamic.dsainkotlin.arrays.practice.decodeString
import com.karnamic.dsainkotlin.arrays.practice.encodeString
import com.karnamic.dsainkotlin.recursion.checkIfPalindrome
import com.karnamic.dsainkotlin.recursion.printNto1
import com.karnamic.dsainkotlin.recursion.printNto1BackTrack
import com.karnamic.dsainkotlin.recursion.reverseArray


fun main() {
    val originalList = listOf("Hello", "h2o1#w#", "are", "you", "1234")
    val encodedString = encodeString(originalList)
    println("Encoded String: $encodedString")
    val newList = decodeString(encodedString)
    newList.forEach {
        println(it)
    }
}