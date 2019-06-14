/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-09 09:24
 **/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        int remainder;
        boolean result = false;
        while (n > 0) {
            // 求余数
            remainder = n % 2;
            n >>>= 1;

            if (n == 0 && remainder == 1) {
                result = true;
                break;
            } else if (n > 0 && remainder == 1) {
                break;
            }
        }

        return result;
    }
}
