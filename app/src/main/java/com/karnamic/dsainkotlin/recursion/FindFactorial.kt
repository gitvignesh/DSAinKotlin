package com.karnamic.dsainkotlin.recursion

/**
 * for a given number n find its factorial. fact(n) = n*(n-1)*...1
 */

fun findFactorialIterative(num: Int): Long {
    if (num <= 0) {
        return 1
    }

    var result = 1L
    for (i in 1 .. num) {
        result *= i
    }
    return result
}

fun findFactorialRecursive(num: Int): Long {
    if (num <= 0) {
        return 1
    }

    return num * findFactorialRecursive(num-1)
}