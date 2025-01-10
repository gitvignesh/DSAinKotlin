package com.karnamic.dsainkotlin.linked_list.practice

import com.karnamic.dsainkotlin.linked_list.SinglyLL

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */

fun<T> reorderList(head: SinglyLL.Node<T>?): Unit {
    if( head?.next == null) {
        return
    }
    var fast = head
    var centre = head

    while(fast?.next != null ) {
        centre = centre?.next
        fast = fast.next?.next
    }

    var curr = centre?.next
    var prev: SinglyLL.Node<T>? = null
    centre?.next = null
    while (curr != null) {
        val temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp
    }

    var reverseHead = prev
    curr = head

    while (reverseHead != null && curr != null) {
        val temp1 = curr.next
        val temp2 = reverseHead.next

        curr.next = reverseHead
        reverseHead.next = temp1
        curr = temp1
        reverseHead = temp2
    }

    return
}