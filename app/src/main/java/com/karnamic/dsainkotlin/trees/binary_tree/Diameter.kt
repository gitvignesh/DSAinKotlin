package com.karnamic.dsainkotlin.trees.binary_tree

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
fun diameterOfBinaryTree(root: TreeNode?): Int {
    var maxDiameter = 0

    fun dfs(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }

        val leftHeight = dfs(root.left)
        val rightHeight = dfs(root.right)
        maxDiameter = maxOf(maxDiameter, leftHeight+rightHeight)
        return 1 + maxOf(leftHeight, rightHeight)
    }

    dfs(root)

    return maxDiameter
}