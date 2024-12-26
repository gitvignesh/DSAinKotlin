package com.karnamic.dsainkotlin.trees.binary_tree

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */

fun maxDepthUsingDFS(root: TreeNode?): Int {
    val stack = ArrayDeque<Pair<TreeNode?, Int>>()
    stack.addFirst(Pair(root, 0))
    var maxDepth = 0

    while (stack.isNotEmpty()) {
        val (currNode, currDepth) = stack.removeFirst()

        if (currNode != null) {
            maxDepth = maxOf(maxDepth, currDepth)
            stack.addFirst(Pair(currNode.left, currDepth + 1))
            stack.addFirst(Pair(currNode.right, currDepth + 1))
        }
    }

    return maxDepth
}