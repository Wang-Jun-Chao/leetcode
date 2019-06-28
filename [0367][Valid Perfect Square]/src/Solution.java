/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 15:10
 **/
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }

        if (num == 0 || num == 1) {
            return true;
        }

        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int sqrt = num / mid;
            if (mid == sqrt && num % mid == 0) {
                return true;
            } else if (mid > sqrt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }

        return false;
    }
}
