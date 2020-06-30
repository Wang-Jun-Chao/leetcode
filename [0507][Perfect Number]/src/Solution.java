/**
 * Author: 王俊超
 * Time: 2020-06-29 08:33
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num < 6) {
            return false;
        }

        int sum = 1;
        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return sum == num;
    }
}
