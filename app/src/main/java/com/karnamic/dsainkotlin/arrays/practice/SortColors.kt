package com.karnamic.dsainkotlin.arrays.practice

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */
fun sortColors(input: IntArray) {

    /* single pass quick sort partition */
    fun sortColorsFast(input: IntArray): Unit {
        var left = 0
        var right = input.size - 1
        var i = 0

        fun swap(i: Int, j: Int) {
            val temp = input[i]
            input[i] = input[j]
            input[j] = temp
        }

        while(i <= right) {
            if(input[i] == 0) {
                swap(left, i)
                left +=1
            } else if (input[i] == 2) {
                swap (right, i)
                right -= 1
                i -= 1
            }
            i += 1
        }
    }

    sortColorsFast(input)

    /*Bubble sort
    for (pass in input.size-1 downTo 0) {
        for(i in 0 until pass) {
            var temp = input[i]
            if ( input[i] > input[i+1]) {
                input[i] = input[i+1]
                input[i+1] = temp
            }
        }
    }
    */

    /*Insertion sort
    for (i in 1 until input.size) {
        val curr =  input[i]
        var j = i
        while (j >= 1 && input[j-1] > curr){
            input[j] = input[j-1]
            j--
        }
        input[j] = curr
    }
    */

    /* Selection Sort
    for( i in input.indices){
        var min = i
        for(j in i+1 until input.size) {
            if (input[j] < input[min]) {
                min = j
            }
        }

        val temp = input[i]
        input[i] = input[min]
        input[min] = temp
    }
    */
}