package com.karnamic.dsainkotlin

import com.karnamic.dsainkotlin.Search.binarySearchRecursive


fun main() {
    val list = arrayListOf(1,2,3,4,5,6,7)

    val searchResult = binarySearchRecursive(list,0)

    if (searchResult == -1) {
        println("Item not found")
    } else {
        println("Item found at index $searchResult")
    }
}