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
    val outMap = hashMapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    val opened = arrayListOf<Char>()

    for (bracket in s) {

        if(outMap.contains(bracket)){
            if (opened.isEmpty()) {
                return false
            } else {
                if (outMap[bracket] != opened.last()){
                    return false
                } else {
                    opened.removeLast()
                }
            }
        } else {
            opened.add(bracket)
        }
    }

    return opened.isEmpty()
}