/**
 * Author: 王俊超
 * Time: 2020-06-29 08:44
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 **/
public class Solution {
    public int fib(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }

        int n2 = 0;
        int n1 = 1;
        int n0;
        for (int i = 2; i <= N; i++) {
            n0 = n1 + n2;
            n2 = n1;
            n1 = n0;
        }

        return n1;
    }
}
