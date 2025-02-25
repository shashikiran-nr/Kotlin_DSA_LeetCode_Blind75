package based_on_data_structure.array

/**
 * 217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
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
 *
 * Explanation:
 * All elements are distinct.
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

fun main() {
    val nums = intArrayOf(1,2,2,4)
    println("${containsDuplicate(nums)}")
}

fun containsDuplicate(nums: IntArray): Boolean {
    // Brute Force - O(n2)
//    for(i in nums.indices) {
//        for(j in i+1..<nums.size) {
//            if(nums[j] == nums[i] ) {
//                return true
//            }
//        }
//    }

    // Optimal solution
    val visited = mutableSetOf<Int>()
    for(i in nums.indices) {
//        if (visited.contains(nums[i])) {
//            return true
//        } else {
//            visited.add(nums[i])
//        }
        // or
        // Best approach in kotlin
        if(!visited.add(nums[i])) {
            return true
        }
    }
    return false
}