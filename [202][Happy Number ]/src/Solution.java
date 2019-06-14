import java.util.HashSet;

/**
 * Author: 王俊超
 * Date: 2015-06-17
 * Time: 21:36
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Write an algorithm to determine if a number is "happy".
     * A happy number is a number defined by the following process: Starting with any positive integer,
     * replace the number by the sum of the squares of its digits, and repeat the process until the number
     * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those
     * numbers for which this process ends in 1 are happy numbers.
     *
     * 题目要求对任意一个正整数，不断各个数位上数字的平方和，若最终收敛为1，则该数字为happy number，
     * 否则程序可能从某个数开始陷入循环。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        if (n < 1) {
            return false;
        }

        // 用于保存中间出现的结果
        HashSet<Integer> set = new HashSet<>(32);

        int tmp;
        int newN;

        // n不为1，并且n的值不能重复出现，否则会死循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            newN = 0;
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }

            n = newN;
        }

        return n == 1;
    }

}
