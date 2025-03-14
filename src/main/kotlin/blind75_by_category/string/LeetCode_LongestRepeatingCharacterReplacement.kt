package blind75_by_category.string

/**
 * 424. Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other
 * uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 *
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 *
 */
fun main() {
    val s = "AABABBA"
    val k = 1
    val result = characterReplacement(s, k)
    println("The length of longest sub-array with repeating character is $result")
}
fun characterReplacement(s: String, k: Int): Int {
    val n = s.length
    var left = 0
    var maxFreqOfChar = 0
    var maxWindowSize = 0
    val freqArray = IntArray(26)


    // Optimal Solution
    for(right in 0 until n) {

        // update the frequency of every char
        freqArray[s[right] - 'A']++

        // finding the maxFreq
        maxFreqOfChar = maxFreqOfChar.coerceAtLeast(freqArray[s[right] - 'A'])

        // window size
        var currWindowSize = right - left + 1

        // char to change : windowSize - maxFreqOfChar
        if(currWindowSize - maxFreqOfChar > k) {
            freqArray[s[left] - 'A']--
            left++
        }
        // re-cal window size after moving left
        currWindowSize = right - left + 1
        maxWindowSize = maxWindowSize.coerceAtLeast(currWindowSize)
    }
    return maxWindowSize
}