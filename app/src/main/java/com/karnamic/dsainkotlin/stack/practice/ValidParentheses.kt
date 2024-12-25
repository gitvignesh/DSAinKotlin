package com.karnamic.dsainkotlin.stack.practice

/***
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

fun isValid(s: String): Boolean {
    val closeToOpen = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    val stack = ArrayDeque<Char>()

    for (char in s) {
        if (closeToOpen.contains(char) && stack.isNotEmpty()) {
            val top = stack.removeFirst()
            if (top != closeToOpen[char]){
                return false
            }
        } else {
            stack.addFirst(char)
        }
    }

    return stack.isEmpty()
}