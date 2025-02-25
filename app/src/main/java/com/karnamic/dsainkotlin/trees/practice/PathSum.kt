package com.karnamic.dsainkotlin.trees.practice

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
fun hasPathSum(root: TreeNode?, targetSum: Long): Boolean {
    if (root == null) {
        return false
    }
    val newTarget = targetSum - root.`val`

    if (root.left == null && root.right == null) {
        return newTarget == 0L
    }

    return hasPathSum(root.right, newTarget) || hasPathSum(root.left, newTarget)
}