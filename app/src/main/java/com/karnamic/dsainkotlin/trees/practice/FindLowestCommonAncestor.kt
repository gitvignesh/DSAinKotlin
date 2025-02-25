package com.karnamic.dsainkotlin.trees.practice

import com.karnamic.dsainkotlin.trees.TreeNode

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q
 * as descendants (where we allow a node to be a descendant of itself).”
 */
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var current = root

    while (current != null && p != null && q != null) {
        if (p.`val` > current.`val` && q.`val` > current.`val`) {
            current = current.right
        } else if ( p.`val`< current.`val` && q.`val` < current.`val`){
            current = current.left
        } else {
            return current
        }
    }

    return current

}