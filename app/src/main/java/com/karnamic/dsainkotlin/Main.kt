package com.karnamic.dsainkotlin

import com.karnamic.dsainkotlin.arrays.practice.decodeString
import com.karnamic.dsainkotlin.arrays.practice.encodeString
import com.karnamic.dsainkotlin.recursion.checkIfPalindrome
import com.karnamic.dsainkotlin.recursion.printNto1
import com.karnamic.dsainkotlin.recursion.printNto1BackTrack
import com.karnamic.dsainkotlin.recursion.reverseArray
import com.karnamic.dsainkotlin.trees.bst.insertIntoBST
import com.karnamic.dsainkotlin.trees.bst.printBST
import com.karnamic.dsainkotlin.trees.bst.removeFromBST


fun main() {
    val root = insertIntoBST(null, 1)
    insertIntoBST(root, 25)
    insertIntoBST(root, 4)
    insertIntoBST(root, 35)
    insertIntoBST(root, 3)
    insertIntoBST(root, 2)
    insertIntoBST(root, 7)
    insertIntoBST(root, 45)

    printBST(root)

    removeFromBST(root, 4)

    printBST(root)
}