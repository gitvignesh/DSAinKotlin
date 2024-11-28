package com.karnamic.dsainkotlin.linked_list

interface LinkedList<T> {
    fun insertLast(data: T)
    fun insertFirst(data: T)
    fun insertAt(position: Int, data: T): Boolean

    fun delete(data: T): Boolean
    fun deleteFirst(): T?
    fun deleteLast(): T?

    fun find(data: T): Boolean
    fun display()
    fun size(): Int
}