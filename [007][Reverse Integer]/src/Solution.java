/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:10
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Reverse digits of an integer.
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     *
     * 题目大意
     * 输入一个整数对其进行翻转
     *
     * 解题思路
     * 通过求余数求商法进行操作。
     * </pre>
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long tmp = x;
        // 防止结果溢出
        long result = 0;

        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }

        return (int) result;
    }
}
