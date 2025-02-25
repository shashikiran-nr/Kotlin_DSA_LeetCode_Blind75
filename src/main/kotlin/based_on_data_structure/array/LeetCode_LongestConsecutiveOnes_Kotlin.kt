package based_on_data_structure.array

/**
 * 1004. Max Consecutive Ones III
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */

fun main() {
    val nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0)
    val k = 2
    val result = longestOnes(nums, k)
    println("The maximum number of consecutive 1's in the array if you can flip at most k is: $result")
}

fun longestOnes(nums: IntArray, k: Int): Int {
    val n = nums.size
    var l = 0
    var r = 0
    var maxLength = 0
    var zerosCount = 0
    // Brute force 0(n)+0(n) - 0(2n)
//    while (r < n) {
//        if (nums[r] == 0) {
//            zerosCount++
//        }
//        while (zerosCount > k) {
//            if (nums[l] == 0) {
//                zerosCount--
//            }
//            l++
//        }
//        val length = r - l + 1
//        maxLength = length.coerceAtLeast(maxLength)
//        r++
//    }


    // Optimal solution by converting while - if (move L by 1) even if it >k
    while (r < n) {
        if (nums[r] == 0) {
            zerosCount++
        }
        if (zerosCount > k) {
            if (nums[l] == 0) zerosCount--
            l++
        }
        val length = r - l + 1
        maxLength = length.coerceAtLeast(maxLength)
        r++
    }
    return maxLength
}