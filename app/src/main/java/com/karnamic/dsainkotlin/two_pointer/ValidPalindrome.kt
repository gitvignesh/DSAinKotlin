package com.karnamic.dsainkotlin.two_pointer

/***
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Constraints:
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */


fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    fun isValid(char: Char) = char.isLetterOrDigit()

    while (left <= right) {
        val leftChar = s[left]
        val rightChar = s[right]

        if(isValid(leftChar) && isValid(rightChar)) {
            if(leftChar.lowercase() != rightChar.lowercase()){
                return false
            } else {
                left++
                right--
            }
        } else if (isValid(leftChar)) {
            right--
        } else {
            left++
        }
    }

    return true

}