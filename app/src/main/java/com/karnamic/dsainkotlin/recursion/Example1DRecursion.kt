package com.karnamic.dsainkotlin.recursion


fun print1ToN(n: Int, current: Int = 1) {
    if (current > n) {
        return
    }
    println(current)
    print1ToN(n, current+1)
}

fun print1ToNBackTrack(n: Int) {
    if (n < 1) {
        return
    }
    print1ToNBackTrack(n-1)
    println(n)
}

fun printNto1(n: Int) {
    if (n < 1) {
        return
    }
    println(n)
    printNto1(n-1)
}

fun printNto1BackTrack(n: Int, current: Int = 1) {
    if (current > n) {
        return
    }
    printNto1BackTrack(n, current+1)
    println(current)
}