/**
 * Author: 王俊超
 * Date: 2015-06-30
 * Time: 20:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Divide two integers without using multiplication, division and mod operator.
     * If it is overflow, return MAX_INT.
     *
     * 题目大意：
     * 不使用除法，乘法和取余，求两个整数的相除的结果，如果有溢出就返回最大的整数
     *
     * 解题思路：
     * 任何一个整数可以表示成以2的幂为底的一组基的线性组合，
     * 即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
     * 基于以上这个公式以及左移一位相当于乘以2，我们先让除
     * 数左移直到大于被除数之前得到一个最大的基。然后接下来我们
     * 每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右
     * 移迭代，直到基为0为止。因为这个方法的迭代次数是按2的幂知
     * 道超过结果，所以时间复杂度为O(log(n))。
     *
     * </pre>
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // 记录结果
        int result = 0;

        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;

            // 修正结果
            result += mul;
        }

        return result * sign;
    }
}
