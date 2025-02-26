package based_on_data_structure.string

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
fun main() {
    val input = "abcabcbb"
    val result = lengthOfLongestSubstring(input)
    println("The length of longest substring in given string without repeating character $result")
}

fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    // Two pointers - algo...
    // Brute Force
    // a b c a b c b b
    // 0 1 2 3 4 5 6 7 ...

//    for (i in s.indices) {
//        val seen = mutableSetOf<Char>() // Set to track unique characters
//        for (j in i until s.length) {
//            if (s[j] in seen) break // Stop if character repeats
//            seen.add(s[j])
//            maxLength = maxOf(maxLength, j - i + 1)
//        }
//        println(seen)
//    }

    // a b c a b c b b
    // 0 1 2 3 4 5 6 7 ...
    // L
    // R
    // Optimal Solution
    val charIndexMap = mutableMapOf<Char, Int>()
    var left = 0
    for (right in s.indices) {
        println("The right : $right")
        val currentChar = s[right]
        // If the character is already in the map and within the current window, update `left`
        if (charIndexMap.containsKey(currentChar) && charIndexMap[currentChar]!! >= left) {
            left = charIndexMap[currentChar]!! + 1
            println("The left : $left")
        }
        // Update the character's latest index
        charIndexMap[currentChar] = right
        println("The charIndexMap: $charIndexMap")
        // Calculate max length
        maxLength = maxOf(maxLength, right - left + 1)
    }
    return maxLength
}