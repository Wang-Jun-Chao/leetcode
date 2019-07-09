/**
 * https://leetcode.com/problems/nth-digit/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 15:56
 **/
public class Solution {
    /**
     * <pre>
     * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
     *
     * Note:
     * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
     *
     * Example 1:
     *
     * Input:
     * 3
     *
     * Output:
     * 3
     * Example 2:
     *
     * Input:
     * 11
     *
     * Output:
     * 0
     *
     * Explanation:
     * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0,
     * which is part of the number 10.
     *
     * https://blog.csdn.net/yeqiuzs/article/details/52573876
     *
     * 思路：
     * 1~9 9个数 9*1=9个digit
     * 10~99 90个数 90*2=180个digit
     * 100~999 900个数 900*3=2700个digit
     * 10^k ~ k个9连成的数 9*10^k个数 (90*10^k)*k个digit
     *
     * 所以给点n，首先确定在几位数之间，如在1000~9999还是在其他之间？然后确定是该区间的哪个数？
     * 最后确定是该数字的哪个digit？
     * 注意防止溢出。
     *
     * </pre>
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        // 记录用多少位
        int k = 1;
        // 记录[10..0(k-1个0), ..., k个9]有多少个数字
        long length = 0;
        while (n > length) {

            // 记录[0, ..., k个9]有多少位
            // [10..0(k-1个0), ..., k个9]有 (int) (9 * k * Math.pow(10, k - 1)) 个数字
            length += (int) (9 * k * Math.pow(10, k - 1));
            k++;
        }

        k--;
        // n >= 9..9, k个9，k取最大满足条件的值，计算有多少个数字
        length -= (int) (9 * k * Math.pow(10, k - 1));
        int num;

        if ((n - length) % k == 0) {
            num = (int) ((int) Math.pow(10, k - 1) + (n - length) / k - 1);
            String s = String.valueOf(num);
            return s.charAt(s.length() - 1) - '0';
        } else {
            num = (int) ((int) Math.pow(10, k - 1) + (n - length) / k);
            String s = String.valueOf(num);
            return s.charAt((int) ((n - length) % k - 1)) - '0';
        }

    }
}
