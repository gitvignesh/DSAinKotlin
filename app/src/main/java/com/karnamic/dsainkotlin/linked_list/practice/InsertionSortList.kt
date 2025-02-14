package com.karnamic.dsainkotlin.linked_list.practice

import com.karnamic.dsainkotlin.linked_list.SinglyLL

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 *
 * The steps of the insertion sort algorithm:
 *
 * Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
 * It repeats until no input elements remain.
 */
fun <T : Comparable<T>> insertionSortList(head: SinglyLL.Node<T>?): SinglyLL.Node<T>? {
    val dummy: SinglyLL.Node<T>? = SinglyLL.Node(next = head)

    var curr = head?.next
    var prev = head

    while (prev != null && curr != null) {
        if ( curr.data > prev.data) {
            prev = curr
            curr = curr.next
            continue
        }

        var sortHead = dummy
        while (sortHead != null && sortHead.next!!.data < curr.data) {
            sortHead = sortHead.next
        }

        prev.next = curr.next
        curr.next = sortHead?.next
        sortHead?.next = curr
        curr = prev.next
    }

    return dummy?.next
}