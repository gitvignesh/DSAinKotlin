package com.karnamic.dsainkotlin.stack

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */

class MinStack() {

    private val content: MutableList<Pair<Int, Int>> = mutableListOf()

    fun push(`val`: Int) {
        val topElement = content.lastOrNull()
        var min = `val`
        if (topElement != null) {
            min = minOf(min, topElement.second)
        }
        content.add(Pair(`val`, min))
    }

    fun pop() {
        if(content.isNotEmpty()) {
            content.removeLast()
        }
    }

    fun top(): Int {
        return content.last()?.first ?: -1
    }

    fun getMin(): Int {
        return content.last()?.second ?: -1
    }

}