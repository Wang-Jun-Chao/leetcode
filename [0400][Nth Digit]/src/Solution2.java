/**
 * https://leetcode.com/problems/nth-digit/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-09 15:56
 **/
public class Solution2 {
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
     * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
     *
     * https://www.cnblogs.com/grandyang/p/5891871.html
     *  </pre>
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long len = 1;
        int cnt = 9;
        int start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            ++len;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String t = "" + start;
        return t.charAt((int) ((n - 1) % len)) - '0';
    }
}
