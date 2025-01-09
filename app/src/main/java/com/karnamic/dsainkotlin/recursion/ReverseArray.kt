package com.karnamic.dsainkotlin.recursion

/**
 * Write a recursive function to reverse An Array
 */

fun<T> reverseArray(array: Array<T>, i: Int = 0) {
    val size = array.size - 1

    if (i > size/2) {
        return
    }

    array[i] = array[size - i].also {
        array[size - i] = array [i]
    }

    reverseArray(array, i+1)
}