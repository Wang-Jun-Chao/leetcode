/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:52
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Determine whether an integer is a palindrome. Do this without extra space.
     *
     * 题目大意
     * 判断一个数字是否是回访字数，不要使用额外的空间。
     *
     * 解题思路
     * 为了不使用额外的空间，参考了其它的解决，那些解法看起来在isPalindrome方法中没有使用额外参数，
     * 但是却使用了方法调用，这个比一个整数消耗的空间更多 ，并没有达到题目的要求，是假的实现，
     * 所以本题依然采用一个额外的空间进行实现。
     *  首先，负数不是回文数字，其次对数字进行逆转，123变成321这样，如果变换后的数字相等说明是回文数字。
     * </pre>
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        // 负数不是回访数字
        if (x < 0) {
            return false;
        }

        // 数字逆转后的值，为了不使用溢出采用long
        long reverse = 0;
        int tmp = x;

        // 求逆转后的值
        while (tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }

        // 判断是否是回文数字
        return x == reverse;
    }
}
