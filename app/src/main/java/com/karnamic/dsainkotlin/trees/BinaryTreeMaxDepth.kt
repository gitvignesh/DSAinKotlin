package com.karnamic.dsainkotlin.trees

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
    if (root == null) return 0

    val stack = ArrayDeque<Pair<TreeNode?, Int>>()
    stack.addFirst(Pair(root, 1))

    var result = 0

    while(stack.isNotEmpty()) {
        val (currNode, currDepth) = stack.removeFirst()

        if (currNode != null) {
            result = maxOf(result, currDepth)
            stack.addFirst(Pair(currNode.left, currDepth + 1))
            stack.addFirst(Pair(currNode.right, currDepth + 1))
        }
    }

    return result
}