package based_on_dsa_patterns.arrays_and_hashing

/**
 *217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false

 * Explanation:*
 * All elements are distinct.
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
fun main () {
    val nums = intArrayOf(1,2,3,4)
    val result: Boolean = containsDuplicate(nums)
    println("The given containsDuplicates : $result")
}

fun containsDuplicate(nums: IntArray): Boolean {
    // Brute force
    for(i in nums.indices) {
        for (j in i+1..<nums.size){
            if(nums[i] == nums[j]) {
                return true
            }
        }
    }

    // Optimal solutions
    // Use set.
    val visited = mutableSetOf<Int>()
    for(i in nums.indices) {
        if(!visited.add(nums[i])) {
            return true
        }
    }
    return false
}