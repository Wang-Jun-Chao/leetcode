/**
 * https://leetcode.com/problems/add-strings/
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-03 04:26
 **/
public class Solution {
    /**
     * <pre>
     * Given two non-negative integers num1 and num2 represented as string, return the sum of
     * num1 and num2.
     *
     * Note:
     *
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * </pre>
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            // 保证第两个字符串不短于第一个
            return addStrings(num2, num1);
        }

        int[] result = new int[num2.length()];

        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int idx3 = result.length - 1;
        int carry = 0;
        while (idx1 >= 0) {
            int a = num1.charAt(idx1) - '0';
            int b = num2.charAt(idx2) - '0';
            result[idx3] = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            idx1--;
            idx2--;
            idx3--;
        }


        // num2还未处理完
        while (idx2 >= 0) {
            int a = num2.charAt(idx2) - '0';
            result[idx3] = (a + carry) % 10;
            carry = (a + carry) / 10;
            idx2--;
            idx3--;
        }

        StringBuilder builder = new StringBuilder();
        if (carry > 0) {
            builder.append(carry);
        }

        for (int i : result) {
            builder.append(i);
        }
        return builder.toString();
    }
}
