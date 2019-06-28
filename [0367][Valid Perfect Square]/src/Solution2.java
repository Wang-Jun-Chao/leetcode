/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-28 15:32
 **/
public class Solution2 {
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

            if (mid < 1) {
                return false;
            }

            int sqrt = num / mid;
            if (mid == sqrt && num % mid == 0) {
                return true;
            } else if (mid < sqrt) {

                if (mid + 1 > num / (mid + 1)) {
                    return false;
                }

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
