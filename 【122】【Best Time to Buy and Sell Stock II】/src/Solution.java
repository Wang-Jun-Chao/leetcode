/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 08:46
 **/
public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buy = 0;
        int sell = 1;

        int sum = 0;
        while (sell < prices.length) {
            // 从buy的位置开始找降序子序列中最小的值
            while (buy + 1 < prices.length && prices[buy] >= prices[buy + 1]) {
                buy++;
            }
            // 从buy的位置开始找升序子序列中最大的值
            sell = buy + 1;
            while (sell + 1 < prices.length && prices[sell] <= prices[sell + 1]) {
                sell++;
            }

            if (sell < prices.length) {
                sum += prices[sell] - prices[buy];
            }

            buy = sell + 1;

        }

        return sum;
    }
}
