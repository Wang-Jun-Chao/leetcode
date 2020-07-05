/**
 * Author: 王俊超
 * Time: 2020-07-05 16:55
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    /**
     * 解题思路：
     * 1、假设b >=a >= 0
     * ==> sqrt(c/2) <= b <= sqrt(c)
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {

        if (c < 0) {
            return false;
        }


        int sqrt = (int) Math.sqrt(c);
        int halfSqrt = (int) Math.sqrt(c / 2.0);

        for (int i = halfSqrt; i <= sqrt; i++) {

            int sqrt2 = (int) Math.sqrt(c - i * i);
            if (sqrt2 * sqrt2 + i * i == c) {
                return true;
            }
        }

        return false;
    }
}
