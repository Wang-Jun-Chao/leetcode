/**
 * Author: 王俊超
 * Date: 2015-06-22
 * Time: 15:42
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (ie, buy one and sell
     * one share of the stock), design an algorithm to find the maximum profit.
     *
     * 题目大意：
     * 给一个数组prices[]，prices[i]代表股票在第i天的售价，求出只做一次交易(一次买入和卖出)能得到的最大收益。
     *
     * 解题思路：
     * 只需要找出最大的差值即可，即 max(prices[j] – prices[i]) ，i < j。一次遍历即可，在遍历的时间用遍历
     * low记录 prices[o....i] 中的最小值，就是当前为止的最低售价，时间复杂度为 O(n)。
     * </pre>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 1) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        // 第i天的价格可以看作是买入价也可以看作是卖出价
        for (int i = 1; i < prices.length; i++) {
            // 找到更低的买入价
            if (min > prices[i]) {
                // 更新买入价
                min = prices[i];
            }
            // 当天的价格不低于买入价
            else {
                // 如果当天买出的价格比之前卖出的价格高
                if (profit < prices[i] - min) {
                    // 更新卖出价
                    profit = prices[i] - min;
                }
            }
        }

        return profit;
    }
}
