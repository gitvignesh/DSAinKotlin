package com.karnamic.dsainkotlin.linked_list.practice

import com.karnamic.dsainkotlin.linked_list.SinglyLL

/***
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
fun <T> reverseList(head: SinglyLL.Node<T>?): SinglyLL.Node<T>? {
    var curr = head
    var prev: SinglyLL.Node<T>? = null

    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}