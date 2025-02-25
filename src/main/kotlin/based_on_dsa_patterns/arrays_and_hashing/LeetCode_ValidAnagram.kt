package based_on_dsa_patterns.arrays_and_hashing

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
fun main() {
    val s = "anagram"
    val t = "nagaram"
    val result = isAnagram(s, t)
    println("The given string is an anagram: $result")
}

fun isAnagram(s: String, t: String): Boolean {
    val sl = s.length
    val tl = t.length
    if(s.length != t.length) {
        return false
    }

    // Brute force
    val sList = s.toMutableList()
    println(sList)
    for (char in t) {
        if (!sList.remove(char)) return false // If a char in 't' is not in 's', return false
    }
    return sList.isEmpty()


    // solved using the HashMap 0(n)
//    val map = mutableMapOf<Char, Int>()
//    for(i in 0 until sl) {
//        val curCharS = s[i]
//        val curCharT = t[i]
//        println("The cur char in S string is  $curCharS")
//        println("The cur char in T string is  $curCharT")
//        map[curCharS] = map.getOrDefault(curCharS, 0) + 1
//        map[curCharT] = map.getOrDefault(curCharT, 0) - 1
//    }
//    for(i in map.values) {
//        if(i != 0) {
//            return false
//        }
//    }

    // Optimal  solution
    val array = IntArray(26)
    println(array.toList())
    for(i in 0..<sl) {
        array[s[i] - 'a']++
    }
    println(array.toList())
    for (i in 0..<tl) {
        array[t[i] - 'a']--
        if(array[t[i] - 'a'] < 0) {
            return false
        }
    }
    println(array.toList())
    return true
}