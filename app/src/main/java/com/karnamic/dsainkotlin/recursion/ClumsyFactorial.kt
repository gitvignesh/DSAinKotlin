package com.karnamic.dsainkotlin.recursion


fun clumsyIterative(n: Int): Int {
    val stack = ArrayDeque<Int>()
    stack.addFirst(n)
    var operationIndex = 0

    for (i in n - 1 downTo 1) {
        when (operationIndex) {
            0 -> { // Multiply
                stack.addFirst(stack.removeFirst() * i)
            }
            1 -> { // Divide
                stack.addFirst(stack.removeFirst() / i)
            }
            2 -> { // Add
                stack.addFirst(i)
            }
            3 -> { // Subtract
                stack.addFirst(-i)
            }
        }
        operationIndex = (operationIndex + 1) % 4
    }


    return stack.sum()
}


fun clumsyRecursive(n: Int): Int {
    // Base cases for small numbers
    if (n == 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2
    if (n == 3) return 6

    // Perform the first group of operations (*, /, +)
    var result = n * (n - 1) / (n - 2) + (n - 3)

    // Subtract the result of the recursive call for the remaining numbers
    return result - clumsyRecursive(n - 4)
}