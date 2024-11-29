package com.karnamic.dsainkotlin

object Search {

    fun <T> binarySearch(
        sortedArray: List<T>,
        target: T
    ): Int where T : Number, T : Comparable<T> {
        var low = 0
        var high = sortedArray.size-1
        var mid: Int

        while (low <= high) {
            mid = low + (high-low)/2

            if (target == sortedArray[mid]) {
                return mid
            } else if (target > sortedArray[mid]) {
                low = mid + 1
            } else {
                high = mid - 1
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
