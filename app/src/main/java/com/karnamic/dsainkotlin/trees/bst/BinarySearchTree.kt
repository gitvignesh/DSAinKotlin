package com.karnamic.dsainkotlin.trees.bst

import com.karnamic.dsainkotlin.trees.TreeNode
import java.util.LinkedList
import java.util.Queue

fun minimumOfBST(root: TreeNode?): Long? {
    var current = root
    while (current?.left != null) {
        current = current.left
    }
    return current?.`val`
}

fun insertIntoBST(root: TreeNode?, value: Long): TreeNode {
    if (root == null) {
        return TreeNode(value)
    }

    if (value > root.`val`) {
        root.right = insertIntoBST(root.right, value)
    } else if (value < root.`val`) {
        root.left = insertIntoBST(root.left, value)
    }

    return root
}

fun removeFromBST(root: TreeNode?, value: Long): TreeNode? {

    if (root == null) {
        return null
    }

    if (value < root.`val`) {
        root.left = removeFromBST(root.left, value)
    } else if (value > root.`val`) {
        root.right = removeFromBST(root.right, value)
    } else {
        if (root.left == null) {
            return root.right
        } else if (root.right == null) {
            return root.left
        } else {
            val minimumOfRight = minimumOfBST(root.right)
            if (minimumOfRight != null) {
                root.`val` = minimumOfRight
                root.right = removeFromBST(root.right, minimumOfRight)
            }
        }
    }

    return root
}

fun printBST(root: TreeNode?) {
    if (root == null) return

    val queue: Queue<TreeNode?> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var allNull = true
        val levelNodes = mutableListOf<String>()

        repeat(levelSize) {
            val node = queue.poll()
            if (node != null) {
                levelNodes.add("${node.`val`}")
                queue.add(node.left)
                queue.add(node.right)
                if (node.left != null || node.right != null) allNull = false
            } else {
                levelNodes.add("N")
            }
        }

        // Stop printing if the entire level is null
        if (!allNull) println(levelNodes.joinToString(" "))
    }
}



