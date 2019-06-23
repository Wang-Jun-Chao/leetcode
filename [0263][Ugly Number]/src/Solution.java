/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-10-10 13:45
 **/
public class Solution {
    public boolean isUgly(int num) {

        if (num < 1) {
            return false;
        } else if (num == 1) {
            return true;
        }

        while ((num % 2) == 0) {
            num /= 2;
        }

        while ((num % 3) == 0) {
            num /= 3;
        }

        while ((num % 5) == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
