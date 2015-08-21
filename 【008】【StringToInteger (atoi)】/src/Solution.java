/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 16:13
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Implement atoi to convert a string to an integer.
     * Hint: Carefully consider all possible input cases. If you want a challenge,
     * please do not see below and ask yourself what are the possible input cases.
     * Notes: It is intended for this problem to be specified vaguely (ie, no given
     * input specs). You are responsible to gather all the input requirements up front.
     *
     * 题目大意
     * 　　实现一个atoi函数，将字符串转成整形
     * 　　要点：考虑所有的输入情况。
     *
     * 解题思路
     * 　　前导字符是+或-或者没有，接下来输入的是数字，数字不能整数能表示的最大或最小数。
     * 如果超过就返回对应的最小或者最小的值。
     * </pre>
     *
     * @param str
     * @return
     */
    public int atoi(String str) {

        if (str == null || str.length() == 0) {
//            throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        }

        // 如果字符串以空格开始
        int start = 0; //从开始找第一个不是空格的数
        boolean positive = true; // 是否为正数默认为true

        if (str.charAt(start) == ' ') {
            while (str.charAt(start) == ' ') {
                start++;
                if (start >= str.length()) { // 输入的全是空格
//                    throw new NumberFormatException("Invalid input string: " + str);
                    return 0;
                }
            }
        }

        if (str.charAt(start) == '-') { // 第一个非空白字符中-
            positive = false;
            start++;
        } else if (str.charAt(start) == '+') {// 第一个非空白字符是+
            start++;
        } else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') { // 第一个非空白字符是数字
            return cal(str, start, true);
        } else { // 其它情况就抛出异常
//            throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        }


        if (start >= str.length()) { // 第一个非空白字符是+或者-但也是最后一个字符
//            throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        }

        if (str.charAt(start) > '9' || str.charAt(start) < '0') { // +或者-后面接的不是数字
//            throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        } else {
            return cal(str, start, positive);
        }
    }

    private int cal(String str, int start, boolean positive) {

        long result = 0;
        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
            result = result * 10 + (str.charAt(start) - '0');

            if (positive) { // 如果是正数
                if (result > Integer.MAX_VALUE) {
//                    throw new NumberFormatException("Invalid input string: " + str);
                    return Integer.MAX_VALUE;
                }

            } else {
                if (-result < Integer.MIN_VALUE) {
//                    throw new NumberFormatException("Invalid input string: " + str);
                    return Integer.MIN_VALUE;
                }
            }

            start++;
        }

        if (positive) {
            return (int) result;
        } else {
            return (int) -result;
        }
    }
}
