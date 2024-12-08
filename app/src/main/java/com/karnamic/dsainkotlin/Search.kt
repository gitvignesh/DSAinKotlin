package com.karnamic.dsainkotlin

object Search {

    fun <T> binarySearch(
        sortedArray: List<T>,
        target: T
    ): Int where T : Number, T : Comparable<T> {
        var left = 0
        var right = sortedArray.size - 1

        while (left <= right) {
            var mid = left + (right - left)/2

            if (target == sortedArray[mid]) return mid

            if (target < sortedArray[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }


    fun <T> binarySearchRecursive(
        sortedArray: List<T>,
        target: T,
        low: Int = 0,
        high: Int = sortedArray.size - 1
    ): Int where T : Number, T : Comparable<T> {

        if (low > high) {
            return -1
        }

        val mid = low + (high - low)/2

        return if (target == sortedArray[mid]) {
            mid
        }else if (target > sortedArray[mid]) {
            binarySearchRecursive(sortedArray, target, mid+1)
        } else {
            binarySearchRecursive(sortedArray, target, 0, mid-1)
        }
    }
}
