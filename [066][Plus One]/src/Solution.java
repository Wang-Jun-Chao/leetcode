/**
 * Author: 王俊超
 * Date: 2015-08-21
 * Time: 19:32
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * 原题
     * Given a non-negative number represented as an array of digits, plus one to the number.
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * 题目大意
     * 给定一个用数组表示的一个数，对它进行加一操作。
     * 每一个数位都存储在数组的一个位置上。数组下标从大到小表示数位从低位到高位。
     *
     * 解题思路
     * 直接求解，设置一个进位标志carry，初值为1，表示加1，从最低位开始tmp = a[x] + carry，
     * a[x] = tmp%10，carry = tmp/10，如果carry不为0对下一位再进行操作，直到所有的数位处理完或者carray
     * 为0就退出，如果最后还有carray不为0说明整个数组要扩展一个数位。
     * </pre>
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int carry = 1; // 进位标志，下一位来的进位标志
        int tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp = digits[i];
            digits[i] = (tmp + carry) % 10; // 计算当前位的新值
            carry = (tmp + carry) / 10; // 计算新的进位

            if (carry == 0) { // 没有进位了就可以退出了
                break;
            }
        }

        if (carry == 1) { // 最后还有一个进位
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        } else {
            return digits;
        }
    }
}
