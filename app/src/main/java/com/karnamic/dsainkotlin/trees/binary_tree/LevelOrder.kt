package com.karnamic.dsainkotlin.trees.binary_tree

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */

fun levelOrder(root: TreeNode?): List<List<Long>> {
    val res = mutableListOf<List<Long>>()
    if (root == null) return res

    val q = ArrayDeque<TreeNode>()
    q.add(root)

    while (q.isNotEmpty()){
        val level = mutableListOf<Long>()
        val qLength = q.size

        for(i in 0 until qLength) {
            val curr = q.removeFirst()
            level.add(curr.`val`)

            curr.left?.let {
                q.add(it)
            }

            curr.right?.let {
                q.add(it)
            }
        }

        res.add(level)
    }

    return res
}