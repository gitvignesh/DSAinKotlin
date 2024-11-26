package com.karnamic.dsainkotlin.linked_list

class SinglyLL<T>: LinkedList<T> {
    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun size() = size

    override fun insertFirst(data: T) {
        val newNode = Node(data, head)
        head = newNode

        val wasEmptyList = head?.next == null
        if (wasEmptyList) {
            tail = head
        }
    }

    override fun insertLast(data: T) {
        val newNode = Node(data, null)
        tail?.next = newNode
        tail = newNode

        val wasEmptyList = head == null
        if (wasEmptyList){
            head = newNode
        }
    }

    override fun insertAt(position: Int, data: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteFirst(): T {
        TODO("Not yet implemented")
    }

    override fun deleteLast(): T {
        TODO("Not yet implemented")
    }

    override fun display() {
        TODO("Not yet implemented")
    }

    override fun find(data: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(data: T): Boolean {
        TODO("Not yet implemented")
    }

    data class Node<T>(var data: T, var next: Node<T>?)
}