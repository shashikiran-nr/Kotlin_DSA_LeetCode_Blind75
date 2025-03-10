package blind75_by_category.string

/**
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
fun main() {
    val strs = arrayOf("eat","tea","tan","ate","nat","bat")
    val result = groupAnagrams(strs)
    println("The list of anagrams in given array of strings : $result")
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    // Brute Force Solution (O(n² * m log m) Time Complexity)
//    val groups = mutableListOf<MutableList<String>>() // Stores grouped anagrams
//    val used = BooleanArray(strs.size) // Tracks which words are already grouped
//    println("Used - Boolean Array at first: ${used.toList()}")
//    for (i in strs.indices) {
//        if (used[i]) {
//            continue
//        }  else {
//        // Skip if already grouped
//            val currentGroup = mutableListOf(strs[i])
//            println("currentGroup - Before inner loop: $currentGroup")
//            used[i] = true
//            println("Used - Boolean Array at after: ${used.toList()}")
//            for (j in i + 1 until strs.size) {
//                if (!used[j] && areAnagrams(strs[i], strs[j])) {
//                    currentGroup.add(strs[j])
//                    used[j] = true
//                }
//                println("used - Boolean Array at after inner loop: ${used.toList()}")
//                println("currentGroup - after inner loop: $currentGroup")
//            }
//            groups.add(currentGroup)
//            println("currentGroup - after inner loop: $currentGroup")
//            println("groups - after inner loop: $groups")
//        }
//    }
//    return groups

    // Optimal solution1 using map and sorting.
    val groupAnagramMap = mutableMapOf<String, MutableList<String>>()
//    for(currWord in strs) {
//        val sortedWord = currWord.toCharArray().sorted().joinToString("")
//        // using map operations
//        groupAnagramMap.computeIfAbsent(sortedWord){ mutableListOf() }.add(currWord)
//
//        // Optimized if block
//        if (!groupAnagramMap.containsKey(sortedWord)) {
//            groupAnagramMap[sortedWord] = mutableListOf()
//        }
//        groupAnagramMap[sortedWord]!!.add(currWord)
//    }

    for(currStr in strs) {
        val array = IntArray(26)
        for(c in currStr.toCharArray()) {
            array[c - 'a']++
        }
        val sb = StringBuilder()
        for(i in array) {
            sb.append("#")
            sb.append(i)
        }
        val key = sb.toString()
        if (!groupAnagramMap.containsKey(key)) {
            groupAnagramMap[key] = mutableListOf()
        }
        groupAnagramMap[key]!!.add(currStr)
    }
    return groupAnagramMap.values.toList()
}

// Helper function to check if two words are anagrams
fun areAnagrams(s1: String, s2: String): Boolean {
    return s1.toCharArray().sorted() == s2.toCharArray().sorted()
}

