/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 13:28
 **/
public class Solution {
    public int addDigits(int num) {

        if (num < 0) {
            throw new IllegalArgumentException("input num :" + num + ", must not be negative");
        }

        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;

            // 需要重新进行位相加
            if (num == 0 && result > 9) {
                num = result;
                result = 0;
            }
        }

        return result;
    }
}
