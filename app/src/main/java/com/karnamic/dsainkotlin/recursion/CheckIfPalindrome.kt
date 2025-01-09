package com.karnamic.dsainkotlin.recursion

/**
 * write a function to check if given string is a palindrome
 */

fun checkIfPalindrome(s: String, i: Int = 0): Boolean {
    val size = s.length - 1

    if (i > size/2) {
        return true
    }

    return if (s[i] != s[size - i]) {
        false
    } else {
        checkIfPalindrome(s, i+1)
    }
}