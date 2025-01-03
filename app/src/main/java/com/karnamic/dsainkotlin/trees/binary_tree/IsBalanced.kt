package com.karnamic.dsainkotlin.trees.binary_tree

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given a binary tree, determine if it is height-balanced
 *
 * height-balanced : A height-balanced binary tree is a binary tree
 * in which the depth of the two subtrees of every node never differs by more than one.
 */
fun isBalanced(root: TreeNode?): Boolean {
    fun dfs(root: TreeNode?): Pair<Boolean, Int> {
        if (root == null) {
            return Pair(true, 0)
        }

        val left = dfs(root.left)
        val right = dfs(root.right)

        val isBalanced = left.first && right.first && Math.abs(left.second - right.second) <= 1

        return Pair(isBalanced, maxOf(left.second, right.second) + 1)
    }

    return dfs(root).first
}