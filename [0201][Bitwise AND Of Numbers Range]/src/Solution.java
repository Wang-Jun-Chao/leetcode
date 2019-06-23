/**
 * Author: 王俊超
 * Date: 2015-06-20
 * Time: 08:56
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
     * of all numbers in this range, inclusive.
     *
     * For example, given the range [5, 7], you should return 4.
     *
     * 题目大意：
     * 给一个范围，返回这个范围中所有的数按位相与最后的结果。
     *
     * 解题思路：
     * 当m!=n，那么最末位必定等0，因为[m, n]必定包含奇偶数，相与最末位等0。可以将m，n都右移一位，
     * 记为mk、 nk，这样就相当于将[m, n]之间的所有的数都右移动了一位，当mk=nk的时候，说明之前
     * [m, n]之间的数右移一位后是相等的，右移后的数作AND操作，结果还是m(=n)，所以操作就可以停止了
     * 记录右移的次数，offset，m>>offset即为所求结果
     * </pre>
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;

        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }

        return m << offset;
    }
}
