package com.karnamic.dsainkotlin.trees.binary_tree

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
fun invertBinaryTree(root: TreeNode?): TreeNode? {
    if(root == null) return null;

    val temp = root.left
    root.left = root.right
    root.right = temp

    invertBinaryTree(root.left)
    invertBinaryTree(root.right)

    return root
}