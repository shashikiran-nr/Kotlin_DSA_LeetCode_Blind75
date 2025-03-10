package blind75_problems_by_category.array

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
fun main() {
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    val result = maxSubArray(nums)
    println("The subarray with the largest sum is: $result")
}

fun maxSubArray(nums: IntArray): Int {
    // Brute force
//    var maxSum = 0
//    for(i in 0..<nums.size) {
//        var currSum = 0
//        for(j in i until nums.size) {
//            currSum += nums[j]
//           maxSum = currSum.coerceAtLeast(maxSum)
//        }
//    }
    // Optimal solution is using an approach called
    // - Memorization means using an already derived result to evaluate further problem(Very common in DP)
    // - Approach called as Kadane's algorithm.
    var maxOfSubArray = nums[0]
    var curSum = nums[0]
    for(i in 1 until nums.size) {
        curSum = Math.max(nums[i], nums[i] + curSum)
        maxOfSubArray = Math.max(curSum, maxOfSubArray)
    }
    return maxOfSubArray
}