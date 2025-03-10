package blind75_by_category.array

/**
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
fun main () {
    val nums = intArrayOf(2, 3, 4, 5)
    val result = productExceptSelf(nums)
    println("The product of given array except self is ${result.toList()}")
}

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n) { 1 }
    val prefix = IntArray(n) { 1 }
    val suffix = IntArray(n) { 1 }
    println("the prefix array before ${prefix.toList()}")
    println("the suffix array before ${suffix.toList()}")
    println("the result array before ${result.toList()}")

    // Brute Force
    //Build prefix product array
    for (i in 1 until n) {
        println("Forloop prefix index : $i")
        println("Forloop prefix ${prefix[i - 1]} and currNum ${nums[i - 1]}")
        prefix[i] = prefix[i - 1] * nums[i - 1]
    }
    println("//////////////////////////////////////////")
    //Build suffix product array
    for (i in n - 2 downTo 0) {
        println("Forloop suffix index : $i")
        println("Forloop suffix ${suffix[i + 1]} ans currNum ${nums[i + 1]}")
        suffix[i] = suffix[i + 1] * nums[i + 1]
    }
    println("the prefix array after ${prefix.toList()}")
    println("the suffix array after ${suffix.toList()}")
    // Multiply prefix and suffix arrays to get the result
    for (i in nums.indices) {
        result[i] = prefix[i] * suffix[i]
    }


    // Optimal Solution
    for(i in 1 until  n) {
        result[i] = result[i-1] * nums[i-1]
    }
    var suffixValue = 1
    for(i in n-2 downTo  0) {
        suffixValue *= nums[i+1]
        result[i] = result[i]*suffixValue
    }
    return result
}
