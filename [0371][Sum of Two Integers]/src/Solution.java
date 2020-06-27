//Calculate the sum of two integers a and b, but you are not allowed to use the
//operator + and -.
//
//
// Example 1:
//
//
//Input: a = 1, b = 2
//Output: 3
//
//
//
// Example 2:
//
//
//Input: a = -2, b = 3
//Output: 1
//
//
//
// Related Topics Bit Manipulation


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Author: 王俊超
 * Time: 2016-07-03 21-25 10:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public int getSum(int a, int b) {

        // 保存不进位值，异或运算结果
        int xor;
        // 保存进位结果，与运算，然后左移一位结果
        int and;
        do {
            xor = a ^ b;
            and = a & b;
            and <<= 1;
            a = xor;
            b = and;

        } while (and != 0);

        return xor;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
