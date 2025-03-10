package blind75_problems_by_category.array

import kotlin.math.max


/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

fun main() {
    val nums = intArrayOf(7,1,5,3,6,4)
    val result = maxProfit(nums)
    println("The maximum profit: $result")
}

fun maxProfit(prices: IntArray): Int {
    val n = prices.size
    // Brute force
    var maxProfit = 0
    for(i in prices.indices) {
        for(j in i+1..<n) {
            val profit = prices[j] - prices[i]
            if(maxProfit < profit) {
                maxProfit = max(maxProfit, profit)
            }
        }
    }

    // Optimal solution
    // Use one more variable as minPrice - prices[0] and loop through
    var minPrice = prices[0]
    for (i in prices.indices) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]
        } else if (maxProfit < (prices[i] - minPrice)) {
            maxProfit = prices[i] - minPrice
        }
    }
    return maxProfit
}
