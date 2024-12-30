package com.karnamic.dsainkotlin.linked_list

class SinglyLL<T>: LinkedList<T> {
    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun size() = size

    override fun insertFirst(data: T) {
        val newNode = Node(data, head)
        head = newNode

        size++

        val wasEmptyList = head?.next == null
        if (wasEmptyList) {
            tail = head
        }
    }

    override fun insertLast(data: T) {
        val newNode = Node(data, null)
        tail?.next = newNode
        tail = newNode

        size++

        val wasEmptyList = head == null
        if (wasEmptyList){
            head = newNode
        }
    }

    override fun insertAt(position: Int, data: T): Boolean {
        if (position < 0 || position > size) {
            return false
        }

        if (position == 0) {
            insertFirst(data)
            return true
        }

        var previous: Node<T>? = null
        var current = head
        var count = 0

        while (current != null && count < position) {
            previous = current
            current = current.next
            count++
        }


        val newNode = Node(data, current)
        previous?.next = newNode
        size++

        if (newNode.next == null) {
            tail = newNode
        }

        return true
    }

    override fun delete(data: T): Boolean {
        var current = head
        var previous: Node<T>? = null

        while (current != null){
            if (current.data == data) {

                val isHeadNode = previous == null
                val isTailNode = current.next == null

                if (isHeadNode) {
                    head = current.next
                } else {
                    previous?.next = current.next
                }

                if (isTailNode) {
                    tail = previous
                }

                size -= 1

                return true
            }
            previous = current
            current = current.next
        }

        return false
    }

    override fun deleteFirst(): T? {
        val firstValue = head?.data ?: return null
        delete(firstValue)
        return firstValue
    }

    override fun deleteLast(): T? {
        val lastValue = tail?.data ?: return null
        delete(lastValue)
        return lastValue
    }

    override fun display() {
        var curr = head

        while (curr != null) {
            println(curr.data.toString())
            curr = curr.next
        }
    }

    override fun find(data: T): Boolean {
        var curr = head

        while (curr != null){
            if (curr.data == data) {
                return true
            }

            curr = curr.next
        }

        return false
    }

    data class Node<T>(val data: T, var next: Node<T>? = null)
}