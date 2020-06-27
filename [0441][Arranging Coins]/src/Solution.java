//You have a total of n coins that you want to form in a staircase shape, where
//every k-th row must have exactly k coins.
//
// Given n, find the total number of full staircase rows that can be formed.
//
// n is a non-negative integer and fits within the range of a 32-bit signed inte
//ger.
//
// Example 1:
//
//n = 5
//
//The coins can form the following rows:
//¤
//¤ ¤
//¤ ¤
//
//Because the 3rd row is incomplete, we return 2.
//
//
//
// Example 2:
//
//n = 8
//
//The coins can form the following rows:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//Because the 4th row is incomplete, we return 3.
//
// Related Topics Math Binary Search


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Author: 王俊超
 * Time: 2020-06-25 14:22
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 本质是求最大的整数x，使得 x >= n - x(x + 1)/2 >= 0
     * ==>
     * 2x >= 2n - x^2 - x >= 0
     * ==>
     * x^2 + 3x >= 2n >= x^2 + x
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {

        if (n <= 0) {
            return 0;
        }

        long t = 2 * (long) (n);

        long x = (long) Math.sqrt(t);

        while (true) {
            if (x * x + 3 * x < t) {
                x++;
                continue;
            }
            if (x * x + x > t) {
                x--;
                continue;
            }

            break;
        }

        return (int) x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
