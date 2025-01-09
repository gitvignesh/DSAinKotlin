package com.karnamic.dsainkotlin

import com.karnamic.dsainkotlin.recursion.checkIfPalindrome
import com.karnamic.dsainkotlin.recursion.printNto1
import com.karnamic.dsainkotlin.recursion.printNto1BackTrack
import com.karnamic.dsainkotlin.recursion.reverseArray


fun main() {
    val array = arrayOf(1,2,3,4,5)
    array.forEach {
        print(it)
    }
    reverseArray(array)
    println()
    array.forEach {
        print(it)
    }
}