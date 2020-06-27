/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 20:38
 **/
public class Solution {

    /**
     * <pre>
     * Given a non negative integer number num. For every numbers i in the range
     * 0 ≤ i ≤ num calculate the number of 1's in their binary representation and
     * return them as an array.
     *
     * Example 1:
     *
     * Input: 2
     * Output: [0,1,1]
     * Example 2:
     *
     * Input: 5
     * Output: [0,1,1,2,1,2]
     * Follow up:
     *
     * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
     * But can you do it in linear time O(n) /possibly in a single pass?
     * Space complexity should be O(n).
     * Can you do it like a boss? Do it without using any builtin function like
     * __builtin_popcount in c++ or in any other language.
     *
     * 思路：
     * 使用治法，
     * i为偶数 bit(i) = bit(i/2)
     * i为奇数 bit(i) = bit(i/2) + 1
     * </pre>
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        } else if (num == 0) {
            return new int[]{0};
        } else if (num == 1) {
            return new int[]{0, 1};
        }

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] += dp[i / 2];
            // 不是偶数，说明其比 i/2多一个一
            if (i % 2 != 0) {
                dp[i]++;
            }
        }

        return dp;
    }
}
