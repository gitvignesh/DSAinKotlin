package com.karnamic.dsainkotlin.linked_list.practice

import com.karnamic.dsainkotlin.linked_list.SinglyLL

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */

fun <T> middleNode(head: SinglyLL.Node<T>?): SinglyLL.Node<T>? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}