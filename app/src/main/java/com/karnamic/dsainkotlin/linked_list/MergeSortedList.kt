package com.karnamic.dsainkotlin.linked_list

fun <T : Comparable<T>> mergeTwoLists(list1: SinglyLL.Node<T>?, list2: SinglyLL.Node<T>?): SinglyLL.Node<T>? {
    val dummyValue:T = list1?.data ?: list2?.data ?: return null
    val resultHead: SinglyLL.Node<T> = SinglyLL.Node(dummyValue)
    var currResult = resultHead

    var currList1 = list1
    var currList2 = list2

    while (currList1 != null && currList2 != null) {
        if (currList1.data < currList2.data) {
            currResult.next = currList1
            currList1 = currList1.next
        } else {
            currResult.next = currList2
            currList2 = currList2.next
        }
        currResult = currResult.next!!
    }

    currResult.next = currList1 ?: currList2

    return resultHead.next
}